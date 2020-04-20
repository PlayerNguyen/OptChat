package com.playernguyen.optchat.command;

import com.playernguyen.optchat.permission.PermissionTag;
import org.bukkit.command.CommandSender;

import java.util.List;

public class OptChatExecute extends MainCommandInstance {

    public OptChatExecute(String command) {
        super(command, "OptChat Command", PermissionTag.build(PermissionTag.PERMISSIONS_COMMAND, "command"));
        // Put sub-command here
    }

    @Override
    public CommandResult execute(CommandSender sender, List<String> arguments) {
        // Check permission
        if (!sender.hasPermission(getPermission())) {
            return CommandResult.NO_PERMISSION;
        }
        // Check arguments
        if (arguments.size() < 1) {
            return CommandResult.MISSING_ARGUMENTS;
        }
        // Check sub-command
        if (!getSubCommandManager().contains(arguments.get(0))) {
            return CommandResult.COMMAND_NOT_FOUND;
        }
        // Okay, you passed all the conditions, move ahead
        return getSubCommandManager()
                .getSubCommand(arguments.get(0))
                .execute(sender, arguments.subList(1, arguments.size()));
    }

    @Override
    public List<String> tab(CommandSender sender, List<String> arguments) {
        if (arguments.size() >= 2 && getSubCommandManager().contains(arguments.get(0))) {
            return getSubCommandManager()
                    .getSubCommand(arguments.get(0))
                    .tab(sender, arguments.subList(1, arguments.size()));
        }
        return null;
    }
}
