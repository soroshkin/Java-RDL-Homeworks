package org.fundamentals.homework;

public class Dog extends Animal implements HomeProtector, BarkingSound {
    public static final String NAME = "dog";

    @Override
    protected String getName() {
        return NAME;
    }
}
