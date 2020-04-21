package com.playernguyen.optchat.manager;

import java.util.ArrayList;
import java.util.Collection;

public class ContainerManager<T> implements Manager<T> {

    private Collection<T> container;

    public ContainerManager(Collection<T> container) {
        this.container = container;
    }

    public ContainerManager() {
        this.container = new ArrayList<>();
    }

    @Override
    public Collection<T> getContainer() {
        return container;
    }

    @Override
    public T get(T item) {
        return container.stream().filter(i->i == item).findAny().orElse(null);
    }

    @Override
    public void empty() {
        container.clear();
    }

    @Override
    public boolean put(T item) {
        return container.add(item);
    }

    @Override
    public boolean remove(T item) {
        return container.remove(item);
    }

}
