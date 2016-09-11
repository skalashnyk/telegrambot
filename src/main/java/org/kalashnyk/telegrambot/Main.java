package org.kalashnyk.telegrambot;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 * @author Sergii Kalashnyk
 */
public class Main {
    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new ImageResenderBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
