package org.fundamentals.homework.animals;

import org.fundamentals.homework.animals.behavior.MiceCatcher;
import org.fundamentals.homework.animals.sounds.MeowSound;

public class Cat extends Animal implements MiceCatcher, MeowSound {
    public static final String NAME = "cat";

    @Override
    protected String getName() {
        return NAME;
    }
}
