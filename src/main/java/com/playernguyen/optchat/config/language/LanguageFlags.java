package com.playernguyen.optchat.config.language;

import com.playernguyen.optchat.config.ConfigurableFlags;

public enum  LanguageFlags implements ConfigurableFlags {

    DEFAULT_CHANNEL_NAME        ("channel.default.display", "&eGlobal"),

    COMMAND_NO_PERMISSION_FIND  ("command.no-permission", "&cYou have no permissions to do this."),
    COMMAND_MISSING_ARGUMENT    ("command.missing-argument",  "&cMissing arguments"),
    COMMAND_NOT_FOUND           ("command.command-not-found",  "&cCommand not found")
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