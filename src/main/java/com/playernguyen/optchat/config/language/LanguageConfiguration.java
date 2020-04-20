package com.playernguyen.optchat.config.language;

import com.playernguyen.optchat.config.YamlFileConfiguration;
import org.bukkit.ChatColor;

import java.io.IOException;

public class LanguageConfiguration extends YamlFileConfiguration {

    private static final String NAME = "language.yml";

    public LanguageConfiguration() {
        super(NAME);
        this.init();
    }

    @Override
    protected void init() {
        // If not found the file
        if (!getFile().exists()) {
            getConfiguration().options().copyDefaults(true);
            // Load and save default instance of this file
            for (LanguageFlags value : LanguageFlags.values()) {
                if (!getConfiguration().contains(value.getPath())) {
                    getConfiguration().addDefault(value.getPath(), value.getInstance());
                }
            }

            // And then save the file
            try {
                this.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.loadFromFile();
    }

    public String getLanguage(LanguageFlags flags) {
        return ChatColor.translateAlternateColorCodes('&', this.getString(flags));
    }
}
