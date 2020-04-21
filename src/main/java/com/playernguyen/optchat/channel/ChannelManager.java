package com.playernguyen.optchat.channel;

import com.playernguyen.optchat.manager.ContainerManager;
import com.playernguyen.optchat.user.User;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

/**
 * Managing channels
 */
public class ChannelManager extends ContainerManager<Channel> {

    private Channel defaultChannel;

    /**
     * Immutable class to contain all channel
     */
    public ChannelManager() {
        super(new LinkedList<>());

        // Create default channel
        this.defaultChannel = new ChannelDefault();
        this.put(defaultChannel);
    }

    /**
     * Search channel in server
     * @param id id of channel to search
     * @return the channel or null if found nothing
     */
    @Nullable
    public Channel getChannel(String id) {
        return this.getContainer()
                .stream()
                .filter(channel -> channel.getId().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    /**
     * Get the default channel (global)
     * @return The default channel in server
     */
    public Channel getDefaultChannel() {
        return defaultChannel;
    }

    /**
     * Create custom channel
     * @param id the id name of channel
     * @return The channel which has just created
     */
    public Channel createChannel(String id, User owner, int size) {
        // Create channel
        Channel channel = new ChannelInstance(id, owner, size);

        // Put
        this.put(channel);

        // Return
        return channel;
    }
}
