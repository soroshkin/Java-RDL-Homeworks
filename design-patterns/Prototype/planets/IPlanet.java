package Prototype.planets;

import Prototype.creatures.ICreature;

public interface IPlanet {
    void addCreature(ICreature creature); // создать новое существо
    long getPopulation(); // количество проживающих
}
