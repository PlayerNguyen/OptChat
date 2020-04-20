package com.playernguyen.optchat.permission;

/**
 * Node is the path of permission, this class use for building a permission
 */
public class NodeBuilder {

    private String holder;

    public NodeBuilder(String holder) {
        this.holder = holder;
    }

    public NodeBuilder() {
    }

    private String getHolder() {
        return holder;
    }

    /**
     * Add new node into holder string
     * @param s the node you want to add
     * @return this instance
     */
    public NodeBuilder add(String s) {
        this.holder = this.holder.concat(".").concat(s);
        return this;
    }

    public String build() {
        return this.getHolder();
    }
}
