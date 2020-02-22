package org.fundamentals.example;

public interface StrongTyped extends Typization {
    @Override
    default String type() {
        return "strongly-typed";
    }
}
