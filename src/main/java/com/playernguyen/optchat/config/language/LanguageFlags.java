package com.playernguyen.optchat.config.language;

import com.playernguyen.optchat.config.ConfigurableFlags;

public enum  LanguageFlags implements ConfigurableFlags {

    PREFIX                      ("main.prefix", "&c[&7OptChat&c]"),

    DEFAULT_CHANNEL_NAME        ("channel.default.display", "&eGlobal"),

    COMMAND_NO_PERMISSION_FIND  ("command.no-permission", "&cYou have no permissions to do this."),
    COMMAND_MISSING_ARGUMENT    ("command.missing-argument",  "&cMissing arguments"),
    COMMAND_NOT_FOUND           ("command.command-not-found",  "&cCommand not found"),

    COMMAND_LIST_HEADER         ("command.channel.list.header", "&eChannel List:"),

    MESSAGE_ON_ANOTHER_CHANNEL  ("message.on-another-channel", "&cYou are on another channel, please try to leave first.")
    ;

    private String path;
    private Object instance;

    LanguageFlags(String path, Object instance) {
        this.path = path;
        this.instance = instance;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public Object getInstance() {
        return instance;
    }
}
