package Prototype.creatures;

public class Humanoid extends ACreature {
    private static int humanoidSerial = 0;

    public Humanoid(String name) {
        super(name);
    }

    public Humanoid(Humanoid creature) {
        super(creature);
        if (creature != null) {
            this.name = creature.getName();
        }
    }

    @Override
    public String getName() {
        return name + humanoidSerial++;
    }

    @Override
    public ICreature clone() {
        return new Humanoid(this);
    }

    @Override
    public String toString() {
        return "Humanoid{" +
                "name='" + name + '\'' +
                '}';
    }
}
