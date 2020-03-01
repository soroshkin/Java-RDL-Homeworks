package org.fundamentals.homework;

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
            default:
                return new UnknownAnimal(name);
        }
    }

    public static void printAnimalByName(Animal animal) {
        System.out.println(animal.getDescription());
    }
}
