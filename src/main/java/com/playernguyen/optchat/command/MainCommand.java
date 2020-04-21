package com.playernguyen.optchat.command;

import com.playernguyen.optchat.OptChatProvider;
import com.playernguyen.optchat.config.language.LanguageFlags;
import com.playernguyen.optchat.util.TextList;
import org.bukkit.ChatColor;
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
                                .getPrefixedLanguage(LanguageFlags.COMMAND_NO_PERMISSION_FIND))
                ;
                break;
            }
            // If missing an arguments
            case MISSING_ARGUMENTS: {
                commandSender.sendMessage(
                        OptChatProvider
                                .getInstance().getLanguageConfiguration()
                                .getPrefixedLanguage(LanguageFlags.COMMAND_MISSING_ARGUMENT)

                );
                break;
            }
            // If the command/sub-command not found
            case COMMAND_NOT_FOUND: {
                commandSender.sendMessage(
                        OptChatProvider
                                .getInstance().getLanguageConfiguration()
                                .getPrefixedLanguage(LanguageFlags.COMMAND_NOT_FOUND)

                );
                break;
            }
            // Success catch
            case SUCCESS: default: {
                // Return success will do nothing
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
