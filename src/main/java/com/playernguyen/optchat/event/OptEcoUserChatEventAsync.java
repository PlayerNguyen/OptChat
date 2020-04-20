package com.playernguyen.optchat.event;

import com.playernguyen.optchat.user.User;
import org.bukkit.event.Cancellable;

public class OptEcoUserChatEventAsync extends UserEvent implements Cancellable {

    private String message;
    private boolean cancelled = false;

    public OptEcoUserChatEventAsync(User user, String message) {
        super(true, user);
        this.message = message;
    }

    /**
     * The message which user has chat
     * @return the message
     */
    public String getMessage() {
        return message;
    }


    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
