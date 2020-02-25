package org.fundamentals.example;

public interface DynamicTyped extends Typization {
    @Override
    default String type() {
        return "dynamically-typed";
    }
}
