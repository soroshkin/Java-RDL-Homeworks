package org.fundamentals.homework.animals.sounds;

public interface FrrSound extends SoundMaker {
    @Override
    default String makeSound() {
        return AnimalSounds.FRR.getSound();
    }
}
