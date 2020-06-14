package net.rusoil.telegram.bot.quiz.java.bot;

import lombok.extern.slf4j.Slf4j;
import net.rusoil.telegram.bot.quiz.java.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class QuizBot extends TelegramLongPollingBot {

    private final QuizService quizService;

    @Value("${bot.username}")
    private String userName;
    @Value("${bot.token}")
    private String botToken;

    @Autowired
    public QuizBot(DefaultBotOptions options, QuizService quizService) {
        super(options);
        this.quizService = quizService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.debug("Update received: {}", update);

        SendMessage message = quizService.formMessage(update);

        try {
            execute(message);
        } catch (TelegramApiException exception) {
            log.error("Could not send message: {}", exception.getMessage(), exception);
        }
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

}
