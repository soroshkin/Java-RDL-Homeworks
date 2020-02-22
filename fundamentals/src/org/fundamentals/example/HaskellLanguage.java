package org.fundamentals.example;

public class HaskellLanguage extends Language implements Functional, StrongTyped {
    @Override
    protected String getName() {
        return "Haskell";
    }
}
