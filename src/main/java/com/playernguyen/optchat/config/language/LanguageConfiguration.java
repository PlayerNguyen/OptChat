package com.playernguyen.optchat.config.language;

import com.playernguyen.optchat.config.YamlFileConfiguration;
import org.bukkit.ChatColor;

import java.io.IOException;

public class LanguageConfiguration extends YamlFileConfiguration {

    private static final String NAME = "language.yml";

    public LanguageConfiguration() {
        super(NAME);
    }

    @Override
    protected void init() {
        this.getConfiguration().options().copyDefaults(true);
        // Load and save default instance of this file
        for (LanguageFlags value : LanguageFlags.values()) {
            this.getConfiguration().addDefault(value.getPath(), value.getInstance());
        }

        // And then save the file
        try {
            this.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // And load the configuration
        this.loadFromFile();
    }

    /**
     * Get the language which contain inside the language.yml
     * @param flags {@link com.playernguyen.optchat.config.ConfigurableFlags} of language
     * @return {@link String} language
     */
    public String getLanguage(LanguageFlags flags) {
        return ChatColor.translateAlternateColorCodes('&', this.getString(flags));
    }
    /**
     * Get the language which contain inside the language.yml with prefix
     * @param flags {@link com.playernguyen.optchat.config.ConfigurableFlags} of language
     * @return {@link String} language
     */
    public String getPrefixedLanguage(LanguageFlags flags) {
        return getLanguage(LanguageFlags.PREFIX).concat(" ").concat(getLanguage(flags));
    }
}
