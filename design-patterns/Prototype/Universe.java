package Prototype;

import Prototype.creatures.Humanoid;
import Prototype.creatures.ICreature;
import Prototype.planets.InhabitedPlanet;

public class Universe {
    public static void main(String[] args) {
        InhabitedPlanet proteus = new InhabitedPlanet();
        ICreature humanoid = new Humanoid("zoyd");
        proteus.addCreature(humanoid);
        for (int i = 0; i < 1000; i++) {
            proteus.addCreature(humanoid.clone());
        }

        System.out.println(proteus.getInhabitants());
    }

}
