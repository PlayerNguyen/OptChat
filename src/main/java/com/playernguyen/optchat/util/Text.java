package com.playernguyen.optchat.util;

import com.playernguyen.optchat.OptChat;
import com.playernguyen.optchat.OptChatProvider;

import java.util.Random;

public class Text {

    private static final String RANDOMIZE_CHARSET = "abcdefghmnlkouiprqxyz1234567890";

    /**
     * Text.Builder using to build a text list
     */
    public static class Builder {
        private String holder;



    }

    private static OptChat getInstance() {
        return OptChatProvider.getInstance();
    }

    public static String buildRandomText(int size) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(RANDOMIZE_CHARSET.charAt(new Random().nextInt(RANDOMIZE_CHARSET.length())));
        }
        return builder.toString();
    }

}
