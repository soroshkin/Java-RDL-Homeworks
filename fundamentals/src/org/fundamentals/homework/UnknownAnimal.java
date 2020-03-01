package org.fundamentals.homework;

public class UnknownAnimal extends Animal {
    public static final String UNKNOWN = "unknown";
    public static final String DESCRIPTION = "%s sound is %s behavior is %s";
    private String name;

    public UnknownAnimal(String name) {
        this.name = name;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public String makeAction() {
        return UNKNOWN;
    }

    @Override
    public String makeSound() {
        return UNKNOWN;
    }

    @Override
    public String getDescription() {
        return String.format(DESCRIPTION, getName(), makeSound(), makeAction());
    }
}
