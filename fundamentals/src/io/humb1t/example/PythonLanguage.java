package io.humb1t.example;

public class PythonLanguage extends Language implements DynamicTyped, MultiParadigm {
    @Override
    protected String getName() {
        return "PythonLanguage";
    }
}
