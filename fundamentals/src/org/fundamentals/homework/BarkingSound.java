package org.fundamentals.homework;

public interface BarkingSound extends SoundMaker {
    @Override
    default String makeSound() {
        return AnimalSounds.BARK.getSound();
    }
}
