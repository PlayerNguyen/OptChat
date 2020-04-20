package com.playernguyen.optchat.command;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface Command {

    String getCommand();

    String getDescription();

    String getPermission();

    CommandResult execute(CommandSender sender, List<String> arguments);

    List<String> tab(CommandSender sender, List<String> arguments);

    default String toHelp() {
        StringBuilder builder = new StringBuilder("/");
        if (this instanceof SubCommand) {
            builder
                    .append(((SubCommand)this).getMainCommand())
                    .append(" ")
                    .append(getCommand())
            ;
            if (!((SubCommand)this).getArguments().equalsIgnoreCase("")) {
                builder.append(" ").append(((SubCommand)this).getArguments());
            }
            builder.append(": ").append(getDescription());
        } else {
            builder.append(getCommand()).append(": ").append(getDescription());
        }
        return builder.toString();
    }

}