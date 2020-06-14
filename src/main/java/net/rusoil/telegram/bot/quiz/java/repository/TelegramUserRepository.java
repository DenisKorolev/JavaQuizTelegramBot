package net.rusoil.telegram.bot.quiz.java.repository;

import net.rusoil.telegram.bot.quiz.java.model.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {

    TelegramUser findByUserId(Long userId);
}
