package com.huangxue.s01.Utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonBuilder {
    public static class Object {
        private final JsonObject json;
        public Object() {
            this(new JsonObject());
        }
        public Object(JsonObject obj) {
            this.json = obj==null ? new JsonObject() : obj;
        }

        public JsonObject build(){return this.json.deepCopy();}
        public Object remove(String key) {
            this.json.remove(key);
            return this;
        }

        public Object put(String key, Number value) {
            this.json.addProperty(key, value);
            return this;
        }
        public Object put(String key, Character value) {
            this.json.addProperty(key, value);
            return this;
        }
        public Object put(String key, String value) {
            this.json.addProperty(key, value);
            return this;
        }
        public Object put(String key, Boolean value) {
            this.json.addProperty(key, value);
            return this;
        }
        public Object put(String key, JsonElement value) {
            this.json.add(key, value);
            return this;
        }
    }

    public static class Array {
        private final JsonArray json;
        public Array() {
            this(new JsonArray());
        }
        public Array(JsonArray array) {
            this.json = array==null ? new JsonArray() : array;
        }

        public JsonArray build(){return this.json.deepCopy();}
        public Array remove(int index) {
            this.json.remove(index);
            return this;
        }

        public Array put(String key, Number value) {
            this.json.add(value);
            return this;
        }
        public Array put(String key, Character value) {
            this.json.add(value);
            return this;
        }
        public Array put(String value) {
            this.json.add(value);
            return this;
        }
        public Array put(Boolean value) {
            this.json.add(value);
            return this;
        }
        public Array put(JsonElement value) {
            this.json.add(value);
            return this;
        }
    }
}
