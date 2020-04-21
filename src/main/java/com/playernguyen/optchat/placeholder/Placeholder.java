package com.playernguyen.optchat.placeholder;

import java.util.HashMap;
import java.util.Map;

public class Placeholder {

    public static class Builder {

        private String holdSlot;
        private Map<String, String> replacementMap;

        public Builder(String holdSlot) {
            this.holdSlot = holdSlot;
            this.replacementMap = new HashMap<>();
        }

        public Builder add(String k, String v) {
            this.getReplacementMap().put(k, v);
            return this;
        }

        public Builder add(Map<String, String> newMap) {
            this.getReplacementMap().putAll(newMap);
            return this;
        }

        public String build() {
            String temp = holdSlot;
            for (Map.Entry<String, String> entry : this.getReplacementMap().entrySet()) {
                temp = temp.replace(entry.getKey(), entry.getValue());
            }
            return temp;
        }

        public Map<String, String> getReplacementMap() {
            return replacementMap;
        }
    }

}
