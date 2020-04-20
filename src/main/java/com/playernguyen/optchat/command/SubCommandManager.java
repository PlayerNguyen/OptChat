package com.playernguyen.optchat.command;

import com.playernguyen.optchat.manager.ContainerManager;

import java.util.HashSet;

class SubCommandManager extends ContainerManager<SubCommand> {

    SubCommandManager() {
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

}
