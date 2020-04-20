package com.playernguyen.optchat.command;

import com.playernguyen.optchat.permission.PermissionTag;

public interface SubCommand extends Command {

    String getArguments();

    Command getMainCommand();

    /**
     * Get the fully permission path like optchat.command.sub-command
     * @return The fully permission
     */
    default String getHighestPermission() {
        return PermissionTag.build(getMainCommand().getPermission(), getPermission());
    }
}
