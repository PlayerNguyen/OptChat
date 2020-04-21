package com.playernguyen.optchat.softdepend;

import org.bukkit.Bukkit;

public enum  SoftDependFlags {

    PLACEHOLDERAPI("PlaceholderAPI");

    private String name;

    SoftDependFlags(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Check whether the plugin containing in server or not
     * @return true if containing or false if not
     */
    public boolean contains() {
        return (Bukkit.getServer().getPluginManager().getPlugin(this.name) != null);
    }

}
