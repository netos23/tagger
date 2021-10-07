package ru.fbtw.tagger.service.events;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.fbtw.tagger.domain.enums.EventType;

@Component
public class ConfirmationEventService implements EventService {

	private final String activationCode;

	public ConfirmationEventService(@Value("${activation-code}") String activationCode) {
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
