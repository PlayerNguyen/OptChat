package com.playernguyen.optchat.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.*;
import java.util.stream.Collectors;

public class TextList {

    public static class Builder {
        List<String> holderList = new ArrayList<>();

        public Builder(Collection<String> appender) {
            this.holderList.addAll(appender);
        }

        public TextList.Builder append(String ...line) {
            this.holderList.addAll(Arrays.asList(line));
            return this;
        }

        public TextList.Builder append(List<String> line) {
            this.holderList.addAll(line);
            return this;
        }

        public TextList.Builder append(String line) {
            this.holderList.add(line);
            return this;
        }

        public Builder() {
        }

        public List<String> buildFancy(ChatColor charColor, ChatColor ...propertyColor) {
            List<String> l = new ArrayList<>();
            l.add(TextList.makeHorizontal(holderList, '=', 0, ChatColor.STRIKETHROUGH, ChatColor.GOLD));
            for (String s : holderList) {
                StringBuilder sBuilder = new StringBuilder(s);
                for (ChatColor chatColor : propertyColor) {
                    sBuilder.insert(0, charColor + "* " + chatColor);
                }
                s = sBuilder.toString();
                l.add(s);
            }
            l.add(TextList.makeHorizontal(holderList, '=', 0, ChatColor.STRIKETHROUGH, ChatColor.GOLD));
            return l;
        }

        public List<String> buildMinimal(String startNodes, ChatColor nodesColor) {
            return holderList.stream().map(string -> startNodes+nodesColor+string).collect(Collectors.toList());
        }

        public void send(CommandSender sender, ChatColor charColor, ChatColor ...chatColors) {
            List<String> l = this.buildFancy(charColor, chatColors);
            l.forEach(sender::sendMessage);
        }

        public void sendMinimal(CommandSender sender, ChatColor color) {
            List<String> l = this.buildMinimal("> ", color);
            l.forEach(sender::sendMessage);
        }
    }

    private static String makeHorizontal(List<String> l, char c, int outline, ChatColor ...propertyColor) {
        if (l == null || l.isEmpty()) {
            throw new IllegalStateException("Line cannot be null or empty");
        }
        int max = maxLines(l);
        StringBuilder builder = new StringBuilder();
        if (outline <= 0) {
            outline = 0;
        }
        for (int i = 0; i < outline; i++) {
            builder.append(" ");
        }
        for (ChatColor chatColor : propertyColor) {
            builder.append(chatColor);
        }
        for (int i = 0; i < max; i++) {
            builder.append(c);
        }
        for (int i = 0; i < outline; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private static int maxLines(List<String> l) {
        if (l == null || l.isEmpty()) {
            throw new IllegalStateException("Line cannot be null or empty");
        }
        int max = l.get(0).length();
        for (String s : l) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }
}
