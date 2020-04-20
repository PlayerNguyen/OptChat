package com.playernguyen.optchat.event;

import com.playernguyen.optchat.user.User;

/**
 * User of OptChat event
 */
public abstract class UserEvent extends Event {

    private User user;

    UserEvent(User user) {
        this.user = user;
    }

    public UserEvent(boolean isAsync, User user) {
        super(isAsync);
        this.user = user;
    }

    /**
     * Get user which doing this event
     * @return The user which doing this event
     */
    public User getUser() {
        return user;
    }

}
