package ru.fbtw.tagger.domain.enums;

import ru.fbtw.tagger.domain.dto.events.NewMessageEvent;

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
