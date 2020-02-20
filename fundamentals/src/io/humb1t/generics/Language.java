package io.humb1t.generics;

public class Language<P extends Paradigm, T extends Typization> implements ObjectsWithGroupingAndBehavior {
    private String name;
    private P paradigm;
    private T typization;

    public Language(String name, P paradigm, T typization) {
        this.name = name;
        this.paradigm = paradigm;
        this.typization = typization;
    }

    String getDescription() {
        return name + " is " + typization.type() + " with " + paradigm.specification() + " paradigm language.";
    }

    @Override
    public P getGroup() {
        return paradigm;
    }

    @Override
    public T getBehavior() {
        return typization;
    }

    @Override
    public String toString() {
        return "Language<" + paradigm.getClass().getName() + "," + typization.getClass().getName() + ">";
    }
}
