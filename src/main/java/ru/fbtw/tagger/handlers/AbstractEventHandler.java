package ru.fbtw.tagger.handlers;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractEventHandler<E> implements EventHandler {

	@Override
	public String handle(Object event) {
		return handleInternal((E) event);
	}

	protected abstract String handleInternal(E event);
}
