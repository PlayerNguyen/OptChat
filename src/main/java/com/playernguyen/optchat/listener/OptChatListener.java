package com.playernguyen.optchat.listener;

import com.playernguyen.optchat.OptChat;
import com.playernguyen.optchat.OptChatProvider;
import org.bukkit.event.Listener;

public interface OptChatListener extends Listener {

    default OptChat getInstance() {
        return OptChatProvider.getInstance();
    }

}
