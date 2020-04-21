package com.playernguyen.optchat.softdepend.placeholder;

import com.playernguyen.optchat.OptChat;
import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.user.User;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class OptChatPlaceholderAPIExpansion extends PlaceholderExpansion {

    private OptChat getInstance() {
        return OptChatProvider.getInstance();
    }

    @Override
    public String getIdentifier() {
        return OptChatProvider.getInstance().getDescription().getName();
    }

    @Override
    public String getAuthor() {
        return OptChatProvider.getInstance().getDescription().getAuthors().toString();
    }

    @Override
    public String getVersion() {
        return OptChatProvider.getInstance().getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {

        User user = this.getInstance().getUserManager().getUser(p.getUniqueId());
        /*
        %optchat_channel_id%
         */
        if (params.equalsIgnoreCase("channel_id")) {
            return user.getChannel().getId();
        }

        /*
        %optchat_channel_display%
         */
        if (params.equalsIgnoreCase("channel_display")) {
            return user.getChannel().getData().getDisplayName();
        }

        // todo more things here

        return null;
    }
}
