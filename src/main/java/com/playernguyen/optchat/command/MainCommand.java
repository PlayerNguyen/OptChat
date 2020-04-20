package com.playernguyen.optchat.command;

import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.config.language.LanguageFlags;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.List;

public interface MainCommand extends Command, TabExecutor {

    SubCommandManager getSubCommandManager();

    @Override
    default boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        CommandResult result = this.execute(commandSender, Arrays.asList(strings));
        switch (result) {
            // If no permission result
            case NO_PERMISSION: {
                commandSender.sendMessage(
                        OptChatProvider
                                .getInstance()
                                .getLanguageConfiguration()
                                .getLanguage(LanguageFlags.COMMAND_NO_PERMISSION_FIND))
                ;
                break;
            }
            // If missing an arguments
            case MISSING_ARGUMENTS: {
                commandSender.sendMessage(toHelp());
                commandSender.sendMessage(
                        OptChatProvider
                                .getInstance().getLanguageConfiguration()
                                .getLanguage(LanguageFlags.COMMAND_MISSING_ARGUMENT)

                );
                break;
            }
            // If the command/sub-command not found
            case COMMAND_NOT_FOUND: {
                commandSender.sendMessage(
                        OptChatProvider
                                .getInstance().getLanguageConfiguration()
                                .getLanguage(LanguageFlags.COMMAND_NOT_FOUND)

                );
                break;
            }
            case SUCCESS: default: {
                // Return null or success will do nothing
                break;
            }
        }
        return true;
    }

    @Override
    default List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return tab(commandSender, Arrays.asList(strings));
    }
}
