package org.fundamentals.homework.animals;

import org.fundamentals.homework.animals.behavior.MiceCatcher;
import org.fundamentals.homework.animals.sounds.FrrSound;

public class Hedgehog extends Animal implements MiceCatcher, FrrSound {
    public static final String NAME = "hedgehog";

    @Override
    protected String getName() {
        return NAME;
    }
}
