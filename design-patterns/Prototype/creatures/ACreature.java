package Prototype.creatures;

public abstract class ACreature implements ICreature {
    String name; // имя существа

    public ACreature(String name) {
        this.name = name;
    }

    public ACreature(ACreature creature) {
        if (creature != null){
            this.name = creature.name;
        }
    }

    @Override
    public ICreature clone() {
        return null;
    }
}
