package com.playernguyen.optchat.user;

import com.playernguyen.optchat.channel.Channel;
import org.bukkit.Bukkit;

import java.util.UUID;

public class UserInstance implements User {

    private UUID uniqueId;
    private Channel channel;

    @Deprecated
    public UserInstance(UUID uniqueId, Channel channel) {
        this.uniqueId = uniqueId;
        this.channel =  channel;
    }

    public UserInstance(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public boolean setChannel(Channel channel) {
        this.channel = channel;
        return channel.hasUser(this);
    }

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public boolean isOnline() {
        return (Bukkit.getPlayer(getUniqueId()) != null);
    }

    @Override
    public void leaveCurrent() {
        this.getChannel().leave(this);
    }

    @Override
    public String toString() {
        return "UserInstance{" +
                "uniqueId=" + uniqueId +
                ", channel=" + channel +
                '}';
    }
}
