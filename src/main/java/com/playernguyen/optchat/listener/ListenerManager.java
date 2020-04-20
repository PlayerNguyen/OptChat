package com.playernguyen.optchat.listener;

import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.manager.ContainerManager;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.HashSet;

public class ListenerManager extends ContainerManager<Listener> {

    /**
     * Using set not for re-register (duplicate) listener
     */
    public ListenerManager() {
        super(new HashSet<>());
    }

    @Override
    public void empty() {
        this.getContainer().forEach(HandlerList::unregisterAll);
        super.empty();
    }

    @Override
    public boolean put(Listener item) {
        Bukkit.getServer().getPluginManager().registerEvents(item, OptChatProvider.getInstance());
        return super.put(item);
    }
}
