package net.rusoil.telegram.bot.quiz.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "telegram_user_id")
    private TelegramUser telegramUser;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Answer)) {
            return false;
        }

        Answer answer = (Answer) obj;
        return id != null && id.equals(answer.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
