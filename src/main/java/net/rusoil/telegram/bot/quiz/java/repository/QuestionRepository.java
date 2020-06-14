package net.rusoil.telegram.bot.quiz.java.repository;

import net.rusoil.telegram.bot.quiz.java.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
