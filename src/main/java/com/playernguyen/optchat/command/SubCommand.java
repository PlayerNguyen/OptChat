package com.playernguyen.optchat.command;

public interface SubCommand extends Command {

    String getArguments();

    Command getMainCommand();

}
