package ru.fbtw.tagger.service.events;

import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Component;
import ru.fbtw.tagger.domain.dto.events.NewMessageEvent;
import ru.fbtw.tagger.domain.dto.messages.BotResponse;
import ru.fbtw.tagger.domain.enums.EventType;
import ru.fbtw.tagger.domain.enums.MessageType;
import ru.fbtw.tagger.service.messages.MessageService;
import ru.fbtw.tagger.service.messages.MessageTypeService;

import java.util.Map;

@Component
public class NewMessageEventService extends AbstractEventService<NewMessageEvent> {

    public static final String OK = "ok";

    private Map<MessageType, MessageService> messageServiceMap;
    private final MessageTypeService messageTypeService;

    public NewMessageEventService(MessageTypeService messageTypeService) {
        this.messageTypeService = messageTypeService;
    }

    @Override
    protected String handleInternal(NewMessageEvent event) {
        Message message = event.getMessage();
       messageServiceMap.get(messageTypeService.getMessageType(message))
                .serve(message.getText());
        return OK;
    }

    @Override
    public EventType getEventType() {
        return EventType.MESSAGE_NEW;
    }
}
