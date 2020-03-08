package io.humb1t;

import java.util.Objects;

public class URL {
    private String name;
    private Object data;

    @Override
    public String toString() {
        return "URL{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }

    public String getName() {
        return name;
    }

    public Object getData() {
        return data;
    }

    public URL(String name, Object data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        URL url = (URL) o;
        return Objects.equals(name, url.name) &&
                Objects.equals(data, url.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, data);
    }
}
