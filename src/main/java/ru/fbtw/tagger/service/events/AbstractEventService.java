package ru.fbtw.tagger.service.events;

public abstract class AbstractEventService<E> implements EventService {

	@Override
	@SuppressWarnings("unchecked")
	public String handle(Object event) {
		return handleInternal((E) event);
	}

	protected abstract String handleInternal(E event);
}
