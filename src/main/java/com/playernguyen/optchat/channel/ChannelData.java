package com.playernguyen.optchat.channel;

import com.playernguyen.optchat.user.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Mutable information of {@link Channel} class
 */
public class ChannelData {

    // Prototype
    private String displayName;
    private User owner;
    private List<User> users;
    private int size;

    public ChannelData(String displayName, User owner, int size) {
        this.displayName = displayName;
        this.owner = owner;
        this.users = new LinkedList<>();
        this.size = size;
    }

    /**
     * Get the display name of channel
     * @return the display name of channel
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set new display name for this channel
     * @param displayName the display name to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the current owner of this channel
     * @return The current {@link User} who are owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Change the owner of channel
     * @param owner The owner who will represents for channel
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * The user list of this channel. This is immutable value, you can just add and remove.
     * Not new initialization.
     *
     * @return the list containing all users inside
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Max size that player can join
     * @return the maximum size that player can join
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ChannelData{" +
                "displayName='" + displayName + '\'' +
                ", owner=" + owner +
                ", users=" + users +
                '}';
    }
}
