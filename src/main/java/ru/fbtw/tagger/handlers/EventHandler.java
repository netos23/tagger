package ru.fbtw.tagger.handlers;

import ru.fbtw.tagger.domain.events.EventType;

public interface EventHandler {
	String handle(Object event);

	EventType getEventType();
}
