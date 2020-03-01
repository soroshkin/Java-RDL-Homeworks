package org.fundamentals.homework;

public enum AnimalSounds {
    MEOW("meow"), BARK("woof"), FRR("frr");
    private String sound;

    AnimalSounds(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
