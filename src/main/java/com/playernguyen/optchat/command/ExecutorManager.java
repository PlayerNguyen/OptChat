package com.playernguyen.optchat.command;

import com.playernguyen.optchat.manager.ContainerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

import java.util.HashSet;

/**
 * Contain all executors inside
 */
public class ExecutorManager extends ContainerManager<MainCommand> {


    public ExecutorManager() {
        super(new HashSet<>());
    }

    @Override
    public boolean put(MainCommand item) {
        PluginCommand pluginCommand = Bukkit.getPluginCommand(item.getCommand());
        // If the pC is null
        if (pluginCommand == null) {
            throw new NullPointerException(String.format("Cannot found plugin command %s", item.getCommand()));
        }
        // Set execute
        pluginCommand.setExecutor(item);
        // Then super the put
        return super.put(item);
    }
}
