package ru.fbtw.tagger.handlers;

public interface EventHandler<E> {
	String handle(E event);

	String getEventName();
}
