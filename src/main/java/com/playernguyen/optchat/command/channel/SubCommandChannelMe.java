package com.playernguyen.optchat.command.channel;

import com.playernguyen.optchat.command.Command;
import com.playernguyen.optchat.command.CommandResult;
import com.playernguyen.optchat.command.SubCommandInstance;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SubCommandChannelMe extends SubCommandInstance {
    public SubCommandChannelMe(Command mainCommand) {
        super("me", "", "Check my channel", mainCommand, "me", "*");
    }

    @Override
    public CommandResult execute(CommandSender sender, List<String> arguments) {


        return CommandResult.COMMAND_NOT_FOUND;
    }

    @Override
    public List<String> tab(CommandSender sender, List<String> arguments) {
        return null;
    }
}
