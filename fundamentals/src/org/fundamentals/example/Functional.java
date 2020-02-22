package org.fundamentals.example;

public interface Functional extends Paradigm {
    @Override
    default String specification() {
        return "Functional";
    }
}
