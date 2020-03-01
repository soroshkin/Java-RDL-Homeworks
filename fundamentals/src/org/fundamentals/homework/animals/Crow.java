package org.fundamentals.homework.animals;

import org.fundamentals.homework.animals.behavior.CanFly;
import org.fundamentals.homework.animals.sounds.CawSound;

public class Crow extends Animal implements CanFly, CawSound {
    public static final String NAME = "crow";

    @Override
    public String getName() {
        return NAME;
    }
}
