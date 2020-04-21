package com.playernguyen.optchat.command;

import com.playernguyen.optchat.OptChat;
import com.playernguyen.optchat.OptChatProvider;

public abstract class CommandInstance {

    /**
     * Get the instance of OptChat
     * @return instance
     */
    public OptChat getInstance() {
        return OptChatProvider.getInstance();
    }

}
