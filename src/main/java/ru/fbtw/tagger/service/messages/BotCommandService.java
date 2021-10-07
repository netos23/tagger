package ru.fbtw.tagger.service.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.fbtw.tagger.domain.enums.MessageType;
import ru.fbtw.tagger.service.comands.CommandHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BotCommandService implements MessageService {

    private final String botName;
    private final Map<String, CommandHandler> handlerMap;

    public BotCommandService(@Value("${bot-name}") String botName, List<CommandHandler> handlers) {
        this.botName = botName;

        handlerMap = new HashMap<>();
        handlers.forEach(h -> handlerMap.put(h.getCommandType().getName(), h));
        handlers.forEach(h -> {
            for (String allies : h.getCommandType().getAliases()) {
                handlerMap.put(allies, h);
            }
        });
    }

    @Override
    public Optional<String> serve(String messageText) {
        int commandStart = messageText.indexOf(botName) + botName.length();
        String[] commandWithArgs = messageText.substring(commandStart).trim()
                .split(" ");

        if (commandWithArgs.length > 0) {
            String command = commandWithArgs[0];
            String[] args = null;
            if (commandWithArgs.length > 1) {
                args = new String[commandWithArgs.length - 1];
                System.arraycopy(commandWithArgs, 0, args, 0, args.length);
            }
            return handlerMap.get(command)
                    .handle(args);
        }

        return Optional.empty();
    }

    @Override
    public MessageType getServiceType() {
        return MessageType.BOT_COMMAND;
    }
}
