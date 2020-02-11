package io.humb1t.generics;

public class Language<P extends Paradigm, T extends Typization> {
    private String name;
    private P paradigm;
    private T typization;

    public Language(String name, Class<P> paradigm, Class<T> typization) throws Exception {
        this.name = name;
        this.paradigm = paradigm.newInstance();
        this.typization = typization.newInstance();
    }

    String getDescription() {
        return name + " is " + typization.type() + " with " + paradigm.specification() + " paradigm language.";
    }
}
