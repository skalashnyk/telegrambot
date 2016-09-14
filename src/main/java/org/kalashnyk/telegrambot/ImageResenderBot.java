package org.kalashnyk.telegrambot;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.List;

/**
 * @author Sergii Kalashnyk
 */
public class ImageResenderBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        List<PhotoSize> photos = message.getPhoto();

        SendMessage sendMessageRequest =
                new SendMessage()
                        .setChatId(message.getChatId().toString());

        if (photos != null) {
            SendPhoto sendPhotoRequest =
                    new SendPhoto()
                            .setChatId(message.getChatId().toString())
                            .setPhoto(photos.get(photos.size() - 1).getFileId());

            sendMessageRequest
                    .setText("Baby if you give it to me\n" +
                    "I'll give it to you\n" +
                    "I know what you want");
            try {
                sendPhoto(sendPhotoRequest);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            sendMessageRequest.setText("Send me an image, please!");
        }

        try {
            sendMessage(sendMessageRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }
}