package net.rusoil.telegram.bot.quiz.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {

    @Id
    private Long id;

    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerVariant> variants;

    private String correctAnswer;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Question)) {
            return false;
        }
        Question another = (Question) obj;
        return id != null && id.equals(another.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
