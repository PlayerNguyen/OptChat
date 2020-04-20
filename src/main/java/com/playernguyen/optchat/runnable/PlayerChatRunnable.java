package com.playernguyen.optchat.runnable;

import com.playernguyen.optchat.event.OptEcoUserChatEventAsync;
import com.playernguyen.optchat.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerChatRunnable extends OptChatRunnable {

    private User user;
    private String message;

    public PlayerChatRunnable(Player player, String message) {
        this.user = this.getInstance().getUserManager().getUser(player.getUniqueId());
        this.message = message;
    }

    @Override
    public void run() {
        // Calling new event
        OptEcoUserChatEventAsync event = new OptEcoUserChatEventAsync(getUser(), getMessage());
        Bukkit.getServer().getPluginManager().callEvent(event);
        // Check whether cancel
        if (!event.isCancelled()) {
            this.getUser().getChannel().sendMessage(getMessage());
        }
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
