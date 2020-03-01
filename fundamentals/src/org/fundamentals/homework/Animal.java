package org.fundamentals.homework;

public abstract class Animal implements Behavior, SoundMaker {
    public static final String DESCRIPTION = "%s says %s and %s";

    protected abstract String getName();

    public String getDescription() {
        return String.format(DESCRIPTION, getName(), makeSound(), makeAction());
    }

}
