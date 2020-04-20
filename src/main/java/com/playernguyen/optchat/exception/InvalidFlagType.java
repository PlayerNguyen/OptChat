package com.playernguyen.optchat.exception;

import com.playernguyen.optchat.config.ConfigurableFlags;

public class InvalidFlagType extends RuntimeException {

    public InvalidFlagType(ConfigurableFlags flags) {
        super(String.format("Wrong cast the flags %s with instanceof %s", flags,
                flags.getInstance().getClass().getSimpleName()));
    }
}
