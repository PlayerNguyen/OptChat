package com.playernguyen.optchat;

import com.playernguyen.optchat.channel.ChannelDefault;
import com.playernguyen.optchat.channel.ChannelManager;
import com.playernguyen.optchat.config.language.LanguageConfiguration;
import com.playernguyen.optchat.listener.ListenerManager;
import com.playernguyen.optchat.listener.PlayerJoin;
import com.playernguyen.optchat.listener.AsyncPlayerChat;
import com.playernguyen.optchat.user.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * OptChat main class
 */
public class OptChat extends JavaPlugin {

    // Instance
    private static OptChat instance;

    // Configuration
    private LanguageConfiguration languageConfiguration;

    // Manager
    private ChannelManager channelManager;
    private UserManager userManager;
    private ListenerManager listenerManager;

    /**
     * Enabling the plugin :)
     */
    @Override
    public void onEnable() {
        // Setup instance
        this.setupInstance();
        // Setup config
        this.setupConfig();
        // Setup manager
        this.setupManager();
    }

    @Override
    public void onDisable() {
        this.getUserManager().empty();
        this.getChannelManager().empty();
        this.getListenerManager().empty();
    }

    private void setupConfig() {
        this.languageConfiguration = new LanguageConfiguration();
    }

    /**
     * Setup the channels, users...
     */
    private void setupManager() {
        this.channelManager = new ChannelManager();
        this.userManager = new UserManager();
        this.listenerManager = new ListenerManager();

        // Register default channel
        this.getChannelManager().put(new ChannelDefault());

        // Register listener
        this.getListenerManager().put(new AsyncPlayerChat());
        this.getListenerManager().put(new PlayerJoin());
    }

    /**
     * Set up the instance of this plugin
     */
    private void setupInstance() {
        instance = this;
    }

    /**
     * To get instance, please using {@link OptChatProvider}
     * @return this instance
     */
    static OptChat getInstance() {
        return instance;
    }

    public ChannelManager getChannelManager() {
        return channelManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public LanguageConfiguration getLanguageConfiguration() {
        return languageConfiguration;
    }

    private ListenerManager getListenerManager() {
        return listenerManager;
    }
}
