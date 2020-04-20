package com.playernguyen.optchat.channel;

import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.config.language.LanguageFlags;

public class ChannelDefault extends ChannelInstance{

    public ChannelDefault() {
        super("default",
                new ChannelData(
                        OptChatProvider.getInstance().getLanguageConfiguration().getLanguage(LanguageFlags.DEFAULT_CHANNEL_NAME),
                        null
                )
        );
    }
}
