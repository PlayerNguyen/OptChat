package com.playernguyen.optchat.config.setting;

import com.playernguyen.optchat.config.YamlFileConfiguration;
import org.bukkit.ChatColor;

import java.io.IOException;

public class SettingConfiguration extends YamlFileConfiguration {

    private static final String FILE_NAME = "config.yml";

    public SettingConfiguration() {
        super(FILE_NAME);
    }

    @Override
    protected void init() {
        this.getConfiguration().options().copyDefaults(true);
        // Load setting
        for (SettingFlags value : SettingFlags.values()) {
            this.getConfiguration().addDefault(value.getPath(), value.getInstance());
        }

        // Try to save
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the configuration
        this.loadFromFile();
    }

    public String getString(SettingFlags flags) {
        return super.getString(flags);
    }

    public String getColourString (SettingFlags flags) {
        return ChatColor.translateAlternateColorCodes('&', this.getString(flags));
    }

    public int getInt(SettingFlags flags) {
        return super.getInt(flags);
    }


}
