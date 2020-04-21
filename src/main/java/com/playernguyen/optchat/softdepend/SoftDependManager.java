package com.playernguyen.optchat.softdepend;

import com.playernguyen.optchat.manager.ContainerManager;
import com.playernguyen.optchat.manager.Manager;

import java.util.HashSet;

/**
 * Contain all soft depend flags item
 */
public class SoftDependManager extends ContainerManager<SoftDependFlags> {

    private Manager<SoftDependClass> softDependClass = new ContainerManager<>();

    public SoftDependManager() {
        super(new HashSet<>());
    }

    /**
     * Action hooking
     */
    public void action() {
        // Placeholder API action
        if (this.getContainer().contains(SoftDependFlags.PLACEHOLDERAPI)) {
            // Call API register
            this.getSoftDependClass().put(new SoftDependPlaceholderAPI());
        }

        this.getSoftDependClass().getContainer().forEach(SoftDependClass::set);
    }

    public Manager<SoftDependClass> getSoftDependClass() {
        return softDependClass;
    }

    /**
     * Check if this having an API of bla bla plugin
     * @param flags the flags of soft depend plugin
     * @return true if existed or false if not
     */
    public boolean contain(SoftDependFlags flags) {
        return this.getContainer().contains(flags);
    }

}
