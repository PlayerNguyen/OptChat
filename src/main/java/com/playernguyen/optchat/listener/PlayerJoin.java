package com.playernguyen.optchat.listener;

import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.user.User;
import com.playernguyen.optchat.user.UserInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void  onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        User user = new UserInstance(
                player.getUniqueId(),
                OptChatProvider.getInstance().getChannelManager().getChannel("default")
        );
        OptChatProvider.getInstance().getUserManager().put(user);
    }

}
