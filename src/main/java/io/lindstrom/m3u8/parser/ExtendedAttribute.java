package io.lindstrom.m3u8.parser;

import java.util.Objects;

public class ExtendedAttribute {
    String key;
    String value;
    private boolean quoted;

    ExtendedAttribute(String key, String value, boolean quoted) {
        this.key = key;
        this.value = value;
        this.quoted = quoted;
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }

    public void write(TextBuilder builder) {
        if (quoted)
            builder.addQuoted(key, value);
        else
            builder.add(key, value);
    }

    public String toString() {
        return quoted ? key + "=\"" + value + "\"": key + "=" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtendedAttribute that = (ExtendedAttribute) o;
        return quoted == that.quoted &&
                key.equals(that.key) &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, quoted);
    }
}
