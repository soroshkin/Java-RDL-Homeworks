package org.fundamentals.homework.animals;

import org.fundamentals.homework.animals.sounds.SoundMaker;
import org.fundamentals.homework.animals.behavior.Behavior;

public abstract class Animal implements Behavior, SoundMaker {
    public static final String DESCRIPTION = "%s says %s and %s";

    protected abstract String getName();

    public String getDescription() {
        return String.format(DESCRIPTION, getName(), makeSound(), makeAction());
    }

}
