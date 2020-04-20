package com.playernguyen.optchat.channel;

import com.playernguyen.optchat.manager.ContainerManager;

import java.util.LinkedList;

/**
 * Managing channels
 */
public class ChannelManager extends ContainerManager<Channel> {

    /**
     * Immutable class to contain all channel
     */
    public ChannelManager() {
        super(new LinkedList<>());
    }

    /**
     * Search channel in server
     * @param id id of channel to search
     * @return the channel or null if found nothing
     */
    public Channel getChannel(String id) {
        return this.getContainer()
                .stream()
                .filter(channel -> channel.getId().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }
}
