package io.humb1t.example;

public interface MultiParadigm extends Paradigm {
    @Override
    default String specification() {
        return "Multi-paradigm";
    }
}
