package ru.fbtw.tagger.service;

import org.springframework.stereotype.Service;
import ru.fbtw.tagger.domain.dto.events.VkEvent;
import ru.fbtw.tagger.domain.enums.EventType;
import ru.fbtw.tagger.service.events.EventService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventDispatcherService {
	private final Map<EventType, EventService> handlers;

	public EventDispatcherService(List<EventService> handlers) {
		this.handlers = handlers.stream()
				.collect(Collectors.toMap(EventService::getEventType, handler -> handler));
	}

	public String dispatch(VkEvent event) {
		return handlers.get(event.getType())
				.handle(event.getObject());
	}
}
