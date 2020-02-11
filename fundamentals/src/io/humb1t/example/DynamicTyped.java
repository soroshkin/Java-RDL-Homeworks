package io.humb1t.example;

public interface DynamicTyped extends Typization {
    @Override
    default String type() {
        return "dynamically-typed";
    }
}
