package com.playernguyen.optchat.runnable;

import com.google.common.base.Preconditions;
import com.playernguyen.optchat.config.setting.SettingFlags;
import com.playernguyen.optchat.event.OptChatUserChatEventAsync;
import com.playernguyen.optchat.permission.PermissionTag;
import com.playernguyen.optchat.placeholder.PlaceholderFormat;
import com.playernguyen.optchat.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerChatRunnable extends OptChatRunnable {

    private Player player;
    private User user;
    private String message;

    public PlayerChatRunnable(Player player, String message) {
        this.player = player;
        this.user = this.getInstance().getUserManager().getUser(player.getUniqueId());
        this.message = message;

        Preconditions.checkNotNull(user, "User cannot be null");
    }

    @Override
    public void run() {

        // Calling new event
        OptChatUserChatEventAsync event = new OptChatUserChatEventAsync(getUser(), getMessage());
        Bukkit.getServer().getPluginManager().callEvent(event);

        // Check whether cancel
        if (!event.isCancelled()) {
            // If player can chat with colour
            if (player.hasPermission(PermissionTag.build("optchat", "colorful"))) {
                this.message = ChatColor.translateAlternateColorCodes('&', message);
            }
            this.getUser().getChannel().sendMessage(
                    PlaceholderFormat.format(player, getMessage(), getInstance()
                            .getSettingConfiguration()
                            .getColourString(SettingFlags.SETTINGS_CHAT_PATTERN))
            );
        }
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public Player getPlayer() {
        return player;
    }
}

