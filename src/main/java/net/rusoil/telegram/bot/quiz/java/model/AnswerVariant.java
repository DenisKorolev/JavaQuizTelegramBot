package net.rusoil.telegram.bot.quiz.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AnswerVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String variant;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Override
    public String toString() {
        return variant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerVariant)) {
            return false;
        }

        AnswerVariant that = (AnswerVariant) obj;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
