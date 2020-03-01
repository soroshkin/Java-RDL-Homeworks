package org.fundamentals.homework;

public interface FrrSound extends SoundMaker {
    @Override
    default String makeSound() {
        return AnimalSounds.FRR.getSound();
    }
}
