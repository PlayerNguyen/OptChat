package com.playernguyen.optchat.command;

public abstract class MainCommandInstance implements MainCommand {

    private String command;
    private String description;
    private String permission;
    private SubCommandManager subCommandManager;

    MainCommandInstance(String command, String description, String permission) {
        this.command = command;
        this.description = description;
        this.permission = permission;
        this.subCommandManager = new SubCommandManager();
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public SubCommandManager getSubCommandManager() {
        return subCommandManager;
    }
}
