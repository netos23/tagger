package ru.fbtw.tagger.domain.events;

import com.vk.api.sdk.objects.messages.Message;

public enum EventType {
	CONFIRMATION(Object.class),
	MESSAGE_NEW(NewMessageEvent.class);

	private final Class<?> type;

	EventType(Class<?> type) {
		this.type = type;
	}

	public Class<?> getType() {
		return type;
	}
}
