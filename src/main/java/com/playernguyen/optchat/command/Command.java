package com.playernguyen.optchat.command;

import com.playernguyen.optchat.util.Text;
import com.playernguyen.optchat.util.TextList;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface Command {

    String getCommand();

    String getDescription();

    List<String> getPermissionList();

    CommandResult execute(CommandSender sender, List<String> arguments);

    List<String> tab(CommandSender sender, List<String> arguments);

    default String toHelp() {
        StringBuilder builder = new StringBuilder("/");
        if (this instanceof SubCommand) {
            builder
                    .append(((SubCommand)this).getMainCommand().getCommand())
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

    default boolean hasPermission(CommandSender sender) {
        return getPermissionList().stream().anyMatch(sender::hasPermission);
    }

    default void senderNeedSubHelp(CommandSender sender, SubCommandManager which) {
        new TextList.Builder()
                .append(Text.Decoration.commandHorizontalMake(ChatColor.RED))
                .append(which.toHelpList())
                .sendMinimal(sender, ChatColor.GRAY);
    }

}
