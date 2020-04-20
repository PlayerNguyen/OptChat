package com.playernguyen.optchat.runnable;

import com.playernguyen.optchat.OptChat;
import com.playernguyen.optchat.OptChatProvider;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class OptChatRunnable extends BukkitRunnable {

    public OptChat getInstance() {
        return OptChatProvider.getInstance();
    }

}
