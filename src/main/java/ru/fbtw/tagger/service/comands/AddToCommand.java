package ru.fbtw.tagger.service.comands;

import org.springframework.stereotype.Component;
import ru.fbtw.tagger.domain.enums.CommandType;

import java.util.Optional;

@Component
public class AddToCommand implements CommandHandler{
    @Override
    public Optional<String> handle(String... args) {
        return Optional.empty();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.ADD_TO;
    }
}
