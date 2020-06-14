package net.rusoil.telegram.bot.quiz.java.repository;

import net.rusoil.telegram.bot.quiz.java.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
