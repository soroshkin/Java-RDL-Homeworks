package org.fundamentals.homework.controller;

import org.fundamentals.homework.animals.*;

public class Main {
    public static void main(String[] args) {
        for (String s : args) {
            printAnimalByName(getAnimalByName(s));
        }
    }

    public static Animal getAnimalByName(String name) {
        switch (name.toLowerCase()) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            case "hedgehog":
                return new Hedgehog();
            case "crow":
                return new Crow();
            default:
                return new UnknownAnimal(name);
        }
    }

    public static void printAnimalByName(Animal animal) {
        System.out.println(animal.getDescription());
    }
}
