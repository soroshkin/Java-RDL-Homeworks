package org.fundamentals.homework.animals.sounds;

public interface MeowSound extends SoundMaker {
    @Override
    default String makeSound() {
        return AnimalSounds.MEOW.getSound();
    }
}
