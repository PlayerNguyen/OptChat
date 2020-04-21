package com.playernguyen.optchat.command.channel;

import com.playernguyen.optchat.command.*;
import com.playernguyen.optchat.util.TextList;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SubCommandChannel extends SubCommandInstance {

    private SubCommandManager subCommandManager = new SubCommandManager();

    public SubCommandChannel(Command mainCommand) {
        super("channel", "<args>", "Channel command", mainCommand, "channel", "*");
        // Add sub command
        subCommandManager.put(new SubCommandChannelList(this));
        subCommandManager.put(new SubCommandChannelCreate(this));
    }

    @Override
    public CommandResult execute(CommandSender sender, List<String> arguments) {
        // No permission
        if (!hasPermission(sender)) {
            return CommandResult.NO_PERMISSION;
        }
        // No arguments found
        if (arguments.size() < 1) {
            return CommandResult.MISSING_ARGUMENTS;
        }
        // No sub-command found
        if (subCommandManager.getSubCommand(arguments.get(0)) == null) {
            new TextList.Builder()
                    .append(subCommandManager.toHelpList())
                    .sendMinimal(sender, ChatColor.GRAY);
            return CommandResult.COMMAND_NOT_FOUND;
        }

        return subCommandManager.getSubCommand(arguments.get(0)).execute(sender, arguments.subList(1, arguments.size()));
    }

    @Override
    public List<String> tab(CommandSender sender, List<String> arguments) {
        // Conditions
        if (arguments.size() >= 2) {
            if (subCommandManager.getSubCommand(arguments.get(0)) != null) {
                return subCommandManager
                        .getSubCommand(arguments.get(0)).tab(sender, arguments.subList(1, arguments.size()));
            }
        }
        return subCommandManager.getSubCommandNameList();
    }
}
