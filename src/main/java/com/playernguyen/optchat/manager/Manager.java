package com.playernguyen.optchat.manager;

import java.util.Collection;

public interface Manager<T> {

    /**
     * The container list to contain all items
     * @return Items which has contained
     */
    Collection<T> getContainer();

    /**
     * Put item into container
     * @param item the item which want to contain
     * @return It put into current container
     */
    boolean put(T item);

    /**
     * Remove item out of container
     * @param item the item which want to move out
     * @return It faded out of current container
     */
    boolean remove(T item);

    /**
     * Get the item existed in container
     *
     * @param item The item to get
     * @return The {@link T} class exited in container or null if found nothing
     */
    T get(T item);

    /**
     * Empty the container
     */
    void empty();

}
