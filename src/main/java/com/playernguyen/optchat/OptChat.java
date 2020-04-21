package com.playernguyen.optchat;

import com.playernguyen.optchat.channel.ChannelManager;
import com.playernguyen.optchat.command.ExecutorManager;
import com.playernguyen.optchat.command.OptChatExecute;
import com.playernguyen.optchat.config.language.LanguageConfiguration;
import com.playernguyen.optchat.config.setting.SettingConfiguration;
import com.playernguyen.optchat.listener.AsyncPlayerChat;
import com.playernguyen.optchat.listener.ListenerManager;
import com.playernguyen.optchat.listener.PlayerJoin;
import com.playernguyen.optchat.softdepend.SoftDependFlags;
import com.playernguyen.optchat.softdepend.SoftDependManager;
import com.playernguyen.optchat.user.UserInstance;
import com.playernguyen.optchat.user.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * OptChat main class
 */
public class OptChat extends JavaPlugin {

    // Instance
    private static OptChat instance;

    // Configuration
    private LanguageConfiguration languageConfiguration;
    private SettingConfiguration settingConfiguration;

    // Manager
    private ChannelManager channelManager;
    private UserManager userManager;
    private ListenerManager listenerManager;
    private ExecutorManager executorManager;
    private SoftDependManager softDependManager;

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
        // Set up hook
        this.setupHook();
        // Set up online players
        this.setupOnlinePlayer();
    }

    /**
     * Say bye bye like Quynh tran JP :)
     */
    @Override
    public void onDisable() {
        this.getUserManager().empty();
        this.getChannelManager().empty();
        this.getListenerManager().empty();
    }


    /**
     * Setup hook
     */
    private void setupHook() {

        if (SoftDependFlags.PLACEHOLDERAPI.contains()) {
            this.getLogger().info("[Hooker] PlaceholderAPI found...");
            getSoftDependManager().put(SoftDependFlags.PLACEHOLDERAPI);
        }

        // Call action
        this.getSoftDependManager().action();
    }

    /**
     * If some players still want to mess with us,
     * reload the user manager and put them into.
     */
    private void setupOnlinePlayer() {
        Bukkit.getServer().getOnlinePlayers().forEach(player-> getUserManager().put(
                new UserInstance(player.getUniqueId())
        ));

        getUserManager().getContainer().forEach(user->
                this.getChannelManager().getDefaultChannel().join(user));
    }

    /**
     * Load and exports config
     */
    private void setupConfig() {
        this.settingConfiguration = new SettingConfiguration();
        this.languageConfiguration = new LanguageConfiguration();
    }

    /**
     * Setup the channels, users...
     */
    private void setupManager() {
        this.channelManager = new ChannelManager();
        this.userManager = new UserManager();
        this.listenerManager = new ListenerManager();
        this.executorManager = new ExecutorManager();
        this.softDependManager = new SoftDependManager();

        // Register listener
        this.getListenerManager().put(new AsyncPlayerChat());
        this.getListenerManager().put(new PlayerJoin());

        // Register executor
        this.getExecutorManager().put(new OptChatExecute("optchat"));
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

    /**
     * Instance of Channel Manager
     * @return The current channel manager in OptChat
     */
    public ChannelManager getChannelManager() {
        return channelManager;
    }

    /**
     * Instance of User Manager
     * @return The current user manager in OptChat
     */
    public UserManager getUserManager() {
        return userManager;
    }

    /**
     * Instance of Language Configuration
     * @return The current language configuration in OptChat
     */
    public LanguageConfiguration getLanguageConfiguration() {
        return languageConfiguration;
    }

    /**
     * Instance of Listener Manager
     * @return The current listener manager in OptChat
     */
    private ListenerManager getListenerManager() {
        return listenerManager;
    }

    /**
     * Instance of Executor Manager
     * @return The current executor manager in OptChat
     */
    private ExecutorManager getExecutorManager() {
        return executorManager;
    }

    /**
     * Instance of Soft Depend Manager
     * @return The current soft depend manager in OptChat
     */
    public SoftDependManager getSoftDependManager() {
        return softDependManager;
    }

    /**
     * Instance of Setting Configuration
     * @return the current setting configuration in OptChat
     */
    public SettingConfiguration getSettingConfiguration() {
        return settingConfiguration;
    }
}
