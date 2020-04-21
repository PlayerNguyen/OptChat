package com.playernguyen.optchat.command;

import com.playernguyen.optchat.permission.PermissionTag;

import java.util.ArrayList;
import java.util.List;

public abstract class SubCommandInstance extends CommandInstance implements SubCommand {

    private String command;
    private String arguments;
    private String description;
    private List<String> permissions;
    private Command mainCommand;

    public SubCommandInstance(String command, String arguments, String description, Command mainCommand, String ...permissions) {
        this.command = command;
        this.arguments = arguments;
        this.description = description;
        this.mainCommand = mainCommand;
        this.permissions = new ArrayList<>();

        /*
        Permissions like a node execute.<sub-command>.<sub-command>...
         */
        for (String permission : permissions) {
            this.permissions.add(PermissionTag.build(mainCommand.getCommand(), permission));
        }
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
    public List<String> getPermissionList() {
        return permissions;
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
