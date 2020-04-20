package com.playernguyen.optchat.user;

import com.playernguyen.optchat.channel.Channel;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface User {

    /**
     * @return {@link UUID} of user
     */
    UUID getUniqueId();

    /**
     * Get the current channel which player joining
     * @return Current channel that user joining
     */
    Channel getChannel();

    /**
     * Change the current channel of this user
     * @param channel {@link Channel} to change
     * @return user has changed to that channel or not
     */
    boolean setChannel(Channel channel);

    /**
     * Check if the player's online or not
     * @return The current online state of player
     */
    boolean isOnline();

    /**
     * Leave the current channel
     */
    void leaveCurrent();

    /**
     * This will calling {@link UserAdapter#toPlayer()} method
     * @return the player represents for this user
     */
    default OfflinePlayer toOfflinePlayer() {
        return new UserAdapter(this).toPlayer();
    }

}
