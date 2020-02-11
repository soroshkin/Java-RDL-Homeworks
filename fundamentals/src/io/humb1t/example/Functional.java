package io.humb1t.example;

public interface Functional extends Paradigm {
    @Override
    default String specification() {
        return "Functional";
    }
}
