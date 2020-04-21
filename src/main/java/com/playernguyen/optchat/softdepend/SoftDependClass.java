package com.playernguyen.optchat.softdepend;

import com.google.common.base.Preconditions;

/**
 * Soft depend class to observe and get API from that class
 */
public abstract class SoftDependClass {

    public SoftDependClass(SoftDependFlags flags) {
        // Not found plugin
        Preconditions.checkArgument(flags.contains(), String.format("Not found plugin %s", flags.getName()));

    }

    public abstract void set();

    public abstract Object get(Object ...objects);

}
