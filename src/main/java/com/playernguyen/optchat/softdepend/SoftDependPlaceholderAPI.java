package com.playernguyen.optchat.softdepend;

import com.playernguyen.optchat.softdepend.placeholder.OptChatPlaceholderAPIExpansion;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class SoftDependPlaceholderAPI extends SoftDependClass {


    public SoftDependPlaceholderAPI() {
        super(SoftDependFlags.PLACEHOLDERAPI);
    }

    @Override
    public void set() {
        // Register expansion
        PlaceholderExpansion expansion = new OptChatPlaceholderAPIExpansion();
        if (!expansion.register()) {
            throw new IllegalStateException("Error while register PlaceholderAPI expansion ");
        }
    }

    @Override
    public Object get(Object ...objects) {
        return PlaceholderAPI.setPlaceholders((Player) objects[0], (String) objects[1]);
    }
}
