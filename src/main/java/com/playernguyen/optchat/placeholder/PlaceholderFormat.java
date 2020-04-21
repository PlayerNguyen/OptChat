package com.playernguyen.optchat.placeholder;

import com.google.common.base.Preconditions;
import com.playernguyen.optchat.OptChat;
import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.softdepend.SoftDependFlags;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlaceholderFormat {

    public static String format(Player player, String message, String input) {
        String temp = input;
        // If null
        Preconditions.checkNotNull(input, "The input string cannot be null");
        // If having PlaceholderAPI
        if (OptChatProvider.getInstance().getSoftDependManager().contain(SoftDependFlags.PLACEHOLDERAPI)) {
            temp = PlaceholderAPI.setPlaceholders(player, temp);
        }

        // Minimal placeholder
        // Still re-import the current with PlaceholderAPI
        //
        Placeholder.Builder builder = new Placeholder.Builder(temp);
        // Add default value
        builder.add("%player_name%", player.getName());
        builder.add("%message%", message);
        builder.add("%player_world%", Objects.requireNonNull(player.getLocation().getWorld()).getName());
        builder.add("%player_channel_id%", getInstance().getUserManager().getUser(player.getUniqueId()).getChannel().getId());
        builder.add("%player_channel_display%", getInstance().getUserManager().getUser(player.getUniqueId()).getChannel().getData().getDisplayName());


        return builder.build();
    }

    private static OptChat getInstance() {
        return OptChatProvider.getInstance();
    }

}
