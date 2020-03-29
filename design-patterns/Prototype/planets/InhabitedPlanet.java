package Prototype.planets;

import Prototype.creatures.ICreature;

import java.util.ArrayList;
import java.util.List;

public class InhabitedPlanet extends APlanet {
    public InhabitedPlanet() {
        creatures = new ArrayList<>();
    }

    @Override
    public void addCreature(ICreature creature) {
        creatures.add(creature);
    }

    @Override
    public long getPopulation() {
        return creatures.size();
    }

    public List<ICreature> getInhabitants(){
        return creatures;
    }
}
