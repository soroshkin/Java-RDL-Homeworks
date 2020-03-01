package org.fundamentals.homework.animals;

import org.fundamentals.homework.animals.behavior.HomeProtector;
import org.fundamentals.homework.animals.sounds.BarkingSound;

public class Dog extends Animal implements HomeProtector, BarkingSound {
    public static final String NAME = "dog";

    @Override
    protected String getName() {
        return NAME;
    }
}
