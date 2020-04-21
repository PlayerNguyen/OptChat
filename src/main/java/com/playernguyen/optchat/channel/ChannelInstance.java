package com.playernguyen.optchat.channel;

import com.playernguyen.optchat.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ChannelInstance implements Channel {

    private String id;
    private ChannelData data;

    public ChannelInstance(String id, ChannelData data) {
        this.id = id;
        this.data = data;
    }

    public ChannelInstance(String id, User owner, int size) {
        this.id = id;
        this.data = new ChannelData(id, owner, size);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public ChannelData getData() {
        return data;
    }

    @Override
    public void join(User user) {
        // Set the current channel
        user.setChannel(this);
        // Put into the list
        this.getData().getUsers().add(user);
    }

    @Override
    public void leave(User user) {
        // set the user current channel
        user.setChannel(null);
        // remove
        getData().getUsers().remove(user);
    }

    @Override
    public boolean hasUser(User user) {
        return getData().getUsers().stream().anyMatch(user1 -> user1.equals(user));
    }

    @Override
    public boolean hasUser(UUID uuid) {
        return getData().getUsers().stream().anyMatch(user->user.getUniqueId().equals(uuid));
    }

    @Override
    public void sendMessage(String msg) {

        getData().getUsers().forEach(user -> {
            Player player = Bukkit.getPlayer(user.getUniqueId());

            if (user.isOnline() && player != null) {
                player.sendMessage(msg);
            }
        });
    }

    @Override
    public String toString() {
        return "ChannelInstance{" +
                "id='" + id + '\'' +
                ", data=" + data +
                '}';
    }
}
