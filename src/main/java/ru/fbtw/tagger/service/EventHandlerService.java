package ru.fbtw.tagger.service;

import org.springframework.stereotype.Service;
import ru.fbtw.tagger.domain.VkEvent;
import ru.fbtw.tagger.domain.events.EventType;
import ru.fbtw.tagger.handlers.EventHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventHandlerService {
	private final Map<EventType, EventHandler> handlers;

	public EventHandlerService(List<EventHandler> handlers) {
		this.handlers = handlers.stream()
				.collect(Collectors.toMap(EventHandler::getEventType, handler -> handler));
	}

	public String handle(VkEvent event) {
		return handlers.get(event.getType())
				.handle(event.getObject());
	}
}
