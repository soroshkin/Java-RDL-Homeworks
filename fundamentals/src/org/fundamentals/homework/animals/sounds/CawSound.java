package org.fundamentals.homework.animals.sounds;

public interface CawSound extends SoundMaker {
    @Override
    default String makeSound() {
        return AnimalSounds.CAW.getSound();
    }
}
