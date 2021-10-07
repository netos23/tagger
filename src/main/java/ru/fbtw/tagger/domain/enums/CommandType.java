package ru.fbtw.tagger.domain.enums;

public enum CommandType {
    ADD("add", new String[]{"-a"}, "add new define"),
    ADD_TO("add_to", new String[]{"-at"}, "append to existed define"),
    REMOVE_FROM("remove_from", new String[]{"-rf"}, "remove from existed define"),
    REMOVE("remove", new String[]{"-r"}, "remove define"),
    LIST("list", new String[]{"-l"}, "print list of define"),
    HELP("help", new String[]{"-h"}, "help");

    private final String name;
    private final String[] aliases;
    private final String description;

    CommandType(String name, String[] aliases, String description) {
        this.name = name;
        this.aliases = aliases;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String[] getAliases() {
        return aliases;
    }

    public String getDescription() {
        return description;
    }
}
