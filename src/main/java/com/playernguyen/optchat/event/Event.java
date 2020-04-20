package com.playernguyen.optchat.event;

import com.playernguyen.optchat.OptChat;
import com.playernguyen.optchat.OptChatProvider;
import org.bukkit.event.HandlerList;

public abstract class Event extends org.bukkit.event.Event {

    private static final HandlerList handlerList = new HandlerList();

    Event() { }

    Event(boolean isAsync) {
        super(isAsync);
    }

    /**
     * Calling the {@link OptChatProvider#getInstance()} to quickly get instance of {@link OptChat}
     *
     * @return The instance of {@link OptChat}
     */
    public OptChat getInstance() {
        return OptChatProvider.getInstance();
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
