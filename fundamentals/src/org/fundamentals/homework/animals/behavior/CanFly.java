package org.fundamentals.homework.animals.behavior;

public interface CanFly extends Behavior {
    @Override
    default String makeAction() {
        return AnimalBehavior.FLYING_ANIMAL.getBehavior();
    }
}
