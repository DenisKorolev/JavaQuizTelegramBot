package net.rusoil.telegram.bot.quiz.java.config;

import lombok.extern.slf4j.Slf4j;
import net.rusoil.telegram.bot.quiz.java.bot.QuizBot;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Slf4j
@Configuration
public class TelegramBotConfiguration {

    @Bean
    public TelegramBotsApi telegramBotsApi(QuizBot bot) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();

        log.info("Connecting to proxy {}:{} {}", bot.getOptions().getProxyHost(), bot.getOptions().getProxyPort(),
                bot.getOptions().getProxyType());
        try {
            api.registerBot(bot);
        } catch (TelegramApiRequestException ex) {
            log.error("Can't register bot {}: {}", bot.getBotUsername(), ex.getMessage(), ex);
        }

        return api;
    }

    @Bean
    public DefaultBotOptions defaultBotOptions(@Value("${proxy.host}") final String proxyHost,
                                               @Value("${proxy.port}") final int proxyPort,
                                               @Value("${proxy.type}") final String proxyType) {

        if (StringUtils.isEmpty(proxyType)) {
            return new DefaultBotOptions();
        }
        final DefaultBotOptions defaultBotOptions = new DefaultBotOptions();
        defaultBotOptions.setProxyHost(proxyHost);
        defaultBotOptions.setProxyPort(proxyPort);
        defaultBotOptions.setProxyType(DefaultBotOptions.ProxyType.valueOf(proxyType));

        return defaultBotOptions;
    }
}
