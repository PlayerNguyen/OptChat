package com.playernguyen.optchat.command.channel;

import com.playernguyen.optchat.command.Command;
import com.playernguyen.optchat.command.CommandResult;
import com.playernguyen.optchat.command.SubCommandInstance;
import com.playernguyen.optchat.config.setting.SettingFlags;
import com.playernguyen.optchat.util.Text;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SubCommandChannelCreate extends SubCommandInstance {

    public SubCommandChannelCreate(Command mainCommand) {
        super("create", "[owner] [name]", "Create new channel", mainCommand, "create", "*");
    }

    @Override
    public CommandResult execute(CommandSender sender, List<String> arguments) {
        // If no permission
        if (!hasPermission(sender)) {
            return CommandResult.NO_PERMISSION;
        }
        // Switch to two case
        if (sender instanceof Player) {
            // Create a custom name of id if player don't input name
            String channelId = Text.buildRandomText(5);;
            if (arguments.size() == 1) {
                channelId = arguments.get(0);
            }

            this.getInstance()
                    .getChannelManager()
                    .createChannel(
                            channelId,
                            getInstance().getUserManager().getUser(((Player) sender).getUniqueId()),
                            getInstance().getSettingConfiguration().getInt(SettingFlags.SETTINGS_MAX_SIZE)
                            );
            return CommandResult.SUCCESS;
        }

        return CommandResult.SUCCESS;
    }

    @Override
    public List<String> tab(CommandSender sender, List<String> arguments) {
        return null;
    }
}
