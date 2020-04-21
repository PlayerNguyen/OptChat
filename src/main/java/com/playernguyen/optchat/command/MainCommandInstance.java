package com.playernguyen.optchat.command;

import java.util.Arrays;
import java.util.List;

public abstract class MainCommandInstance extends CommandInstance implements MainCommand {

    private String command;
    private String description;
    private List<String> permissions;
    private SubCommandManager subCommandManager;

    MainCommandInstance(String command, String description, String ... permissions) {
        this.command = command;
        this.description = description;
        this.permissions = Arrays.asList(permissions);
        this.subCommandManager = new SubCommandManager();
    }

    @Override
    public String getCommand() {
        return command;
    }

    public List<String> getPermissionList() {
        return permissions;
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
