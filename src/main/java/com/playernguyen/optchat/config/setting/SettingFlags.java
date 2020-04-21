package com.playernguyen.optchat.config.setting;

import com.playernguyen.optchat.config.ConfigurableFlags;

public enum  SettingFlags implements ConfigurableFlags {

    SETTINGS_CHAT_PATTERN    ("settings.chat-pattern", "%player_channel_display%|%player_name% > %message%"),

    SETTINGS_MAX_SIZE        ("settings.max-size-default", 12)

    ;

    private String path;
    private Object instance;

    SettingFlags(String path, Object instance) {
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
