package ru.fbtw.tagger.handlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.fbtw.tagger.domain.events.EventType;

@Component
public class ConfirmationEventHandler implements EventHandler{

	private final String activationCode;

	public ConfirmationEventHandler(@Value("${activation-code}") String activationCode) {
		this.activationCode = activationCode;
	}

	@Override
	public String handle(Object event) {
		return activationCode;
	}

	@Override
	public EventType getEventType() {
		return EventType.CONFIRMATION;
	}
}
