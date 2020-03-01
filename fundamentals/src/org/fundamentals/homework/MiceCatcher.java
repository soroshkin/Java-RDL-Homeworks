package org.fundamentals.homework;

public interface MiceCatcher  extends Behavior{
    @Override
    default String makeAction() {
        return AnimalBehavior.MICE_CATCHER.getBehavior();
    }
}
