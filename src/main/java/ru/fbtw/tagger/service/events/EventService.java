package ru.fbtw.tagger.service.events;

import ru.fbtw.tagger.domain.enums.EventType;

public interface EventService {
	String handle(Object event);

	EventType getEventType();
}
