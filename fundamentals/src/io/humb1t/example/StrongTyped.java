package io.humb1t.example;

public interface StrongTyped extends Typization {
    @Override
    default String type() {
        return "strongly-typed";
    }
}
