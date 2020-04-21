package com.playernguyen.optchat.command;

import com.playernguyen.optchat.manager.ContainerManager;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SubCommandManager extends ContainerManager<SubCommand> {

    public SubCommandManager() {
        super(new HashSet<>());
    }

    /**
     * Get the sub command containing
     * @param command the sub command to get
     * @return the {@link SubCommand} if found or null if found nothing
     */
    public SubCommand getSubCommand(String command) {
        return getContainer()
                .stream()
                .filter(subCommand -> subCommand.getCommand().equalsIgnoreCase(command))
                .findAny()
                .orElse(null);
    }

    /**
     * Check the sub-command has contained in main command
     * @param command The command to check
     * @return true/false
     */
    public boolean contains(String command) {
        return getContainer().stream().anyMatch(c -> c.getCommand().equalsIgnoreCase(command));
    }

    /**
     * Return the sub-command as list but with the name list (String list)
     * @return The string list of commands name
     */
    public List<String> getSubCommandNameList() {
        return getContainer().stream().map(Command::getCommand).collect(Collectors.toList());
    }

    /**
     * Return the sub-command as list but with the toHelp list (String list)
     * @return The string list of commands help guide
     */
    public List<String> toHelpList() {
        return getContainer().stream().map(Command::toHelp).collect(Collectors.toList());
    }

}
