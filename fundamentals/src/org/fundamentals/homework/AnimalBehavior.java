package org.fundamentals.homework;

public enum AnimalBehavior {
    HOME_GUARDER("protects home"), MICE_CATCHER("catches mice");
    private String behavior;

    public String getBehavior() {
        return behavior;
    }

    AnimalBehavior(String behavior) {
        this.behavior = behavior;
    }
}
