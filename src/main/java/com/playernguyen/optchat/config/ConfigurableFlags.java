package com.playernguyen.optchat.config;

public interface ConfigurableFlags {

    /**
     * @return The path of that config
     */
    String getPath();

    /**
     * @return The instance of that config
     */
    Object getInstance();

}
