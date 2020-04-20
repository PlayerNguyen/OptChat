package com.playernguyen.optchat.user;

import com.playernguyen.optchat.manager.ContainerManager;

import java.util.LinkedList;
import java.util.UUID;

/**
 * Managing users
 */
public class UserManager extends ContainerManager<User> {

    public UserManager() {
        super(new LinkedList<>());
    }

    /**
     * Get the user containing
     * @param uuid the {@link UUID} to get
     * @return the {@link User} existed or null
     */
    public User getUser(UUID uuid) {
        return this.getContainer()
                .stream()
                .filter(user->user.getUniqueId()==uuid)
                .findAny()
                .orElse(null);
    }

}
