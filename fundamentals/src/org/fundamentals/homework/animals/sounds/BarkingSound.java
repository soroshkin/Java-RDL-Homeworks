package org.fundamentals.homework.animals.sounds;

public interface BarkingSound extends SoundMaker {
    @Override
    default String makeSound() {
        return AnimalSounds.BARK.getSound();
    }
}
