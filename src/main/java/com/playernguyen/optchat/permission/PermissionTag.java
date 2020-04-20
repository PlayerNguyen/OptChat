package com.playernguyen.optchat.permission;

public class PermissionTag {
    private static final String PERMISSION_START = "optchat";
    public static final String PERMISSIONS_COMMAND = "command";

    /**
     * Build new permission.
     * @param strings permission node list
     * @return the permission which built
     */
    public static String build(String ...strings) {
        NodeBuilder builder =  new NodeBuilder(PERMISSION_START);
        for (String string : strings) {
            builder.add(string);
        }
        return builder.build();
    }


}
