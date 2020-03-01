package org.fundamentals.homework;

public interface MeowSound extends SoundMaker {
    @Override
    default String makeSound() {
        return AnimalSounds.MEOW.getSound();
    }
}
