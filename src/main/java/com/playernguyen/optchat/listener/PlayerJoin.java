package com.playernguyen.optchat.listener;

import com.playernguyen.optchat.channel.ChannelInstance;
import com.playernguyen.optchat.user.User;
import com.playernguyen.optchat.user.UserInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements OptChatListener {

    @EventHandler
    public void  onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        User user = new UserInstance(player.getUniqueId());

        // Put player
        if (getInstance().getUserManager().put(user)) {
            this.getInstance().getLogger().info(String.format("Putting user %s into the default chat channel", user.getUniqueId()));
        }

        // Then set default channel
        getInstance().getChannelManager().getDefaultChannel().join(user);
    }

}
