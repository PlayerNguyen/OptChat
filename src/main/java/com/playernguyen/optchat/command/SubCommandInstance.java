package com.playernguyen.optchat.command;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommandInstance implements SubCommand {

    private String command;
    private String arguments;
    private String description;
    private String permission;
    private Command mainCommand;

    public SubCommandInstance(String command, String arguments, String description, String permission, Command mainCommand) {
        this.command = command;
        this.arguments = arguments;
        this.description = description;
        this.permission = permission;
        this.mainCommand = mainCommand;
    }

    @Override
    public Command getMainCommand() {
        return mainCommand;
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
    public String getArguments() {
        return arguments;
    }

    @Override
    public String getDescription() {
        return description;
    }


}
