package ru.fbtw.tagger.service.messages;

import com.vk.api.sdk.objects.messages.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.fbtw.tagger.domain.enums.MessageType;

@Service
public class MessageTypeService {

    private final String botName;

    public MessageTypeService(@Value("${bot-name}") String botName) {
        this.botName = botName;
    }


    public MessageType getMessageType(Message message) {
        String text = message.getText();
        if (text != null && !text.isEmpty()) {
            text = text.trim();
            if(text.startsWith(botName)){
                return MessageType.BOT_COMMAND;
            }
        }
        return MessageType.CHAT_MESSAGE;
    }
}
