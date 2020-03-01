package org.fundamentals.homework;

public class Cat extends Animal implements MiceCatcher, MeowSound {
    public static final String NAME = "cat";

    @Override
    protected String getName() {
        return NAME;
    }
}
