package com.playernguyen.optchat.channel;

import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.config.language.LanguageFlags;
import org.bukkit.Bukkit;

public class ChannelDefault extends ChannelInstance{

    public static final String DEFAULT_CHANNEL_ID = "default";

    public ChannelDefault() {
        super(DEFAULT_CHANNEL_ID,
                new ChannelData(
                        OptChatProvider.getInstance().getLanguageConfiguration().getLanguage(LanguageFlags.DEFAULT_CHANNEL_NAME),
                        null,
                        // Max players that player can be join
                        Bukkit.getServer().getMaxPlayers()
                )
        );
    }
}
