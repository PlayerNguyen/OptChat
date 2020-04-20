package com.playernguyen.optchat.user;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class UserAdapter {

    private User user;

    public UserAdapter(User user) {
        this.user = user;
    }

    /**
     * Get the current holder
     * @return Current user holding
     */
    private User getUser() {
        return user;
    }

    /**
     * Change user to the player
     * @return the {@link OfflinePlayer} if the user are not online or {@link Player} if the user are online
     */
    public OfflinePlayer toPlayer() {
        if (!user.isOnline()) return Bukkit.getOfflinePlayer(user.getUniqueId());
        return Bukkit.getPlayer(user.getUniqueId());
    }
}
