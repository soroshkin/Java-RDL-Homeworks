package org.fundamentals.homework.animals.behavior;

public interface HomeProtector extends Behavior {
    @Override
    default String makeAction() {
        return AnimalBehavior.HOME_GUARDER.getBehavior();
    }
}
