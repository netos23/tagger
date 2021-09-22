package ru.fbtw.tagger.handlers;

import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Component;
import ru.fbtw.tagger.domain.events.EventType;

@Component
public class NewMessageEvent extends AbstractEventHandler<Message> {

	@Override
	protected String handleInternal(Message event) {
		System.out.println();
		System.out.println(event);
		System.out.println();
		return "ok";
	}

	@Override
	public EventType getEventType() {
		return EventType.MESSAGE_NEW;
	}
}
