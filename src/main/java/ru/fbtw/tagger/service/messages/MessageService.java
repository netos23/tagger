package ru.fbtw.tagger.service.messages;

import ru.fbtw.tagger.domain.enums.MessageType;

import java.util.Optional;

public interface MessageService {
    Optional<String> serve(String messageText);
    MessageType getServiceType();
}
