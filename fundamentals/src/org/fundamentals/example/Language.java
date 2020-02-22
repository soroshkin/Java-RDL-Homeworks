package org.fundamentals.example;

public abstract class Language implements Paradigm, Typization {
    protected abstract String getName();

    String getDescription() {
        return getName() + " is " + specification() + " and " + type() + " language.";
    }
}
