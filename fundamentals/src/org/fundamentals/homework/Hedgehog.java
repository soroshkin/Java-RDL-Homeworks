package org.fundamentals.homework;

public class Hedgehog extends Animal implements MiceCatcher, FrrSound {
    public static final String NAME = "hedgehog";

    @Override
    protected String getName() {
        return NAME;
    }
}
