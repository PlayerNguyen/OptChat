package com.playernguyen.optchat.command.channel;

import com.playernguyen.optchat.channel.Channel;
import com.playernguyen.optchat.command.Command;
import com.playernguyen.optchat.command.CommandResult;
import com.playernguyen.optchat.command.SubCommandInstance;
import com.playernguyen.optchat.config.language.LanguageFlags;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.stream.Collectors;

public class SubCommandChannelList extends SubCommandInstance {


    public SubCommandChannelList(Command mainCommand) {
        super("list", "", "Show list of channel", mainCommand, "list", "*");
    }

    @Override
    public CommandResult execute(CommandSender sender, List<String> arguments) {
        if (!hasPermission(sender))
            return CommandResult.NO_PERMISSION;

        // Build a great message
        sender.sendMessage(
                this.getInstance().getLanguageConfiguration().getPrefixedLanguage(LanguageFlags.COMMAND_LIST_HEADER)
        );
        this.getInstance().getChannelManager().getContainer().forEach(e->{
            sender.sendMessage(ChatColor.GRAY + " - " + message + ": "
                    + ChatColor.translateAlternateColorCodes('&', ));
        });

        return CommandResult.SUCCESS;
    }

    @Override
    public List<String> tab(CommandSender sender, List<String> arguments) {
        return null;
    }

    private List<String> getChannelList() {
        return this.getInstance()
                .getChannelManager()
                .getContainer()
                .stream()
                .map(Channel::getId)
                .collect(Collectors.toList());
    }
}
