package org.fundamentals.example;

public interface OOP extends Paradigm {
    @Override
    default String specification() {
        return "OOP";
    }
}
