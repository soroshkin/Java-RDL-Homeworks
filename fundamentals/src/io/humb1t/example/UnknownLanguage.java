package io.humb1t.example;

public class UnknownLanguage extends Language {

    private String name;

    UnknownLanguage(String name) {
        this.name = name;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public String specification() {
        return "unknown";
    }

    @Override
    public String type() {
        return "unclear";
    }
}
