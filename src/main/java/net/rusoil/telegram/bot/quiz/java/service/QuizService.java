package net.rusoil.telegram.bot.quiz.java.service;

import net.rusoil.telegram.bot.quiz.java.model.Answer;
import net.rusoil.telegram.bot.quiz.java.model.AnswerVariant;
import net.rusoil.telegram.bot.quiz.java.model.Question;
import net.rusoil.telegram.bot.quiz.java.model.TelegramUser;
import net.rusoil.telegram.bot.quiz.java.repository.QuestionRepository;
import net.rusoil.telegram.bot.quiz.java.repository.TelegramUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private List<Question> questions;

    private final TelegramUserRepository telegramUserRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuizService(TelegramUserRepository telegramUserRepository, QuestionRepository questionRepository) {
        this.telegramUserRepository = telegramUserRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional
    public SendMessage formMessage(Update update) {
        if (questions == null) {
            questions = questionRepository.findAll();
        }

        Long userId = update.getMessage().getChatId();
        TelegramUser telegramUser = telegramUserRepository.findByUserId(userId);
        if (telegramUser == null) {
            telegramUser = createTelegramQuizUser(userId);
            return createQuizMessage(userId, telegramUser.getCurrentQuestion());
        }

        if (telegramUser.isTestFinished()) {
            return createResultMessage(telegramUser);
        }

        return checkAnswerAndFormMessage(update, telegramUser);
    }

    private TelegramUser createTelegramQuizUser(Long userId) {
        var telegramUser = new TelegramUser();
        telegramUser.setUserId(userId);
        telegramUser.setCurrentQuestion(questionRepository.findAll().get(0));
        return telegramUserRepository.save(telegramUser);
    }

    private SendMessage createQuizMessage(TelegramUser telegramUser) {
        return createQuizMessage(telegramUser.getUserId(), telegramUser.getCurrentQuestion());
    }

    private SendMessage createQuizMessage(Long userId, Question question) {

        StringBuilder variants = new StringBuilder();
        for (AnswerVariant answerVariant : question.getVariants()) {
            variants.append(answerVariant.getVariant()).append("\r\n");
        }

        final SendMessage sendMessage = new SendMessage().setChatId(userId).setText(question.getQuestion() + "\r\n"
            + variants.toString());

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add("а");
        row.add("б");

        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("в");
        row.add("г");

        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        sendMessage.setReplyMarkup(keyboardMarkup);

        return sendMessage;
    }

    private SendMessage createResultMessage(TelegramUser telegramUser) {
        long correctAnswers = telegramUser.getAnswers().stream()
                .filter(Answer::isCorrect)
                .count();
        return new SendMessage()
                .setChatId(telegramUser.getUserId())
                .setText("Правильных ответов: " + correctAnswers
                + " из " + questions.size() + "."
                + "\r\nВаша оценка: " + telegramUser.getGrade() + ".")
                .setReplyMarkup(new ReplyKeyboardRemove());
    }

    private SendMessage checkAnswerAndFormMessage(Update update, TelegramUser telegramUser) {
        String userAnswer = update.getMessage().getText();

        if (isAnswerMessage(userAnswer)) {
            var answer = new Answer();
            answer.setQuestion(telegramUser.getCurrentQuestion());
            answer.setCorrect(isAnswerCorrect(userAnswer, telegramUser.getCurrentQuestion()));
            telegramUser.addAnswer(answer);

            if (isLastQuestion(telegramUser.getCurrentQuestion())) {
                countAndSetResults(telegramUser);
                return createResultMessage(telegramUser);
            } else {
                setNextQuestion(telegramUser);
                return createQuizMessage(telegramUser);
            }
        } else {
            return createQuizMessage(telegramUser);
        }
    }

    private boolean isAnswerMessage(String answer) {
        return "а".equalsIgnoreCase(answer) || "б".equalsIgnoreCase(answer)
                || "в".equalsIgnoreCase(answer) || "г".equalsIgnoreCase(answer);
    }

    private boolean isAnswerCorrect(String answer, Question question) {
        return answer.equals(question.getCorrectAnswer());
    }

    private boolean isLastQuestion(Question question) {
        return questions.indexOf(question) == questions.size() - 1;
    }

    private void countAndSetResults(TelegramUser telegramUser) {
        int questionWeight = questions.size() / 5;
        long correctAnswers = telegramUser.getAnswers().stream()
                .filter(Answer::isCorrect)
                .count();
        float grade = (float) (correctAnswers / questionWeight);
        if (grade < 2) {
            grade = 2;
        }
        telegramUser.setGrade((short) Math.round(grade));
        telegramUser.setTestFinished(true);
    }

    private void setNextQuestion(TelegramUser telegramUser) {
        int currentQuestionIndex = questions.indexOf(telegramUser.getCurrentQuestion());
        Long nextQuestionId = questions.get(currentQuestionIndex + 1).getId();
        var nextQuestion = questionRepository.findById(nextQuestionId);
        telegramUser.setCurrentQuestion(nextQuestion.get());
    }
}
