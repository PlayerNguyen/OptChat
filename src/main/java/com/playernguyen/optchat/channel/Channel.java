package com.playernguyen.optchat.channel;

import com.playernguyen.optchat.user.User;

import java.util.List;
import java.util.UUID;

/**
 * Channel is immutable object to container all players into a group
 */
public interface Channel {

    /**
     * Current name of this channel.
     * This id is immutable during the plugin start
     * @return the id of channel
     */
    String getId();

    /**
     * Containing all data of this channel
     * @return current {@link Channel}
     */
    ChannelData getData();

    /**
     * Set user join into the channel
     * @param user {@link User} to join
     */
    void join(User user);

    /**
     * Set user leave the channel
     * @param user user {@link User} to leave
     */
    void leave(User user);

    /**
     * Check whether the user is existed or not
     * @param user The user to check
     * @return That player contained in this channel
     */
    boolean hasUser(User user);

    /**
     * Check whether the user is existed or not with UUID
     * @param uuid The uuid of user to check
     * @return That player contained in this channel
     */
    boolean hasUser(UUID uuid);

    /**
     * Send the message to all users in player
     * @param msg message to send
     */
    void sendMessage(String msg);

    /**
     * Check whether this is a default channel
     * @return true if this is a default or false if not
     */
    default boolean isDefault() {
        return this.getId().equals(ChannelDefault.DEFAULT_CHANNEL_ID);
    }

    /**
     * Get the current list of players which existing in container
     * This method will call {@link ChannelData#getUsers()}
     * @return The current list of players
     */
    default List<User> getUsers() {
        return this.getData().getUsers();
    }

}
