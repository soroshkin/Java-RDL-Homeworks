package org.fundamentals.homework.animals.sounds;

public enum AnimalSounds {
    MEOW("meow"), BARK("woof"), FRR("frr"), CAW("caw");
    private String sound;

    AnimalSounds(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
