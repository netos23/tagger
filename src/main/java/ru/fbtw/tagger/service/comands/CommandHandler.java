package ru.fbtw.tagger.service.comands;

import ru.fbtw.tagger.domain.dto.messages.BotResponse;
import ru.fbtw.tagger.domain.enums.CommandType;

import java.util.Optional;

public interface CommandHandler {
    Optional<String> handle(String ... args);
    CommandType getCommandType();
}
