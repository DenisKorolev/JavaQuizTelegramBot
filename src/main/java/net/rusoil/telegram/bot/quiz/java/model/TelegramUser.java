package net.rusoil.telegram.bot.quiz.java.model;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class TelegramUser {

    @Id
    @Column(nullable = false, unique = true)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question currentQuestion;

    @Column(nullable = false)
    private boolean isTestFinished;

    private Short grade;

    @OneToMany(mappedBy = "telegramUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    public void addAnswer(Answer answer) {
        if (answers == null) {
            answers = new ArrayList<>();
        }
        if (!answers.contains(answer)) {
            answers.add(answer);
        }
        answer.setTelegramUser(this);
    }

    public void deleteAnswer(Answer answer) {
        if (answers != null) {
            answers.remove(answer);
        }
        answer.setTelegramUser(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TelegramUser that = (TelegramUser) obj;
        return userId != null && userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
