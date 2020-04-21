package com.playernguyen.optchat.config;

import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.exception.InvalidFlagType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * This is an abstract class to create new configuration
 * System configuration, not API
 */
public abstract class YamlFileConfiguration {

    private File file;
    private FileConfiguration configuration;

    public YamlFileConfiguration(String name) {
        this.file = new File(OptChatProvider.getInstance().getDataFolder(), name);
        this.loadFromFile();
        this.init();
    }

    protected File getFile() {
        return file;
    }

    protected FileConfiguration getConfiguration() {
        return configuration;
    }

    protected void loadFromFile() {
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    private Object get(ConfigurableFlags flags) {
        return getConfiguration().get(flags.getPath());
    }

    public int getInt(ConfigurableFlags flags) {
        if (!(flags.getInstance() instanceof Integer)) {
            throw new InvalidFlagType(flags);
        }
        return (int) get(flags);
    }

    public String getString(ConfigurableFlags flags) {
        if (!(flags.getInstance() instanceof String)) {
            throw new InvalidFlagType(flags);
        }
        return (String) get(flags);
    }

    public float getFloat(ConfigurableFlags flags) {
        if (!(flags.getInstance() instanceof Float)) {
            throw new InvalidFlagType(flags);
        }
        return (float) get(flags);
    }

    protected abstract void init();

    protected void save() throws IOException {
        this.getConfiguration().save(getFile());
    }
}
