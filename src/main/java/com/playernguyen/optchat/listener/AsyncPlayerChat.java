package com.playernguyen.optchat.listener;

import com.playernguyen.optchat.runnable.PlayerChatRunnable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements OptChatListener {

    /**
     * On player trying to chat
     * @param event {@link AsyncPlayerChatEvent} event
     */
    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent event) {

        // Run the asynchronously task
        PlayerChatRunnable playerChatRunnable = new PlayerChatRunnable(event.getPlayer(), event.getMessage());
        playerChatRunnable.runTaskAsynchronously(getInstance());

        // Cancel the event
        event.setCancelled(true);
    }

}
