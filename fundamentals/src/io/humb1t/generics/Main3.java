package io.humb1t.generics;

public class Main3 {
    public static void main(String[] args) throws Exception {
        printLanguageDescription(getLanguageByName(args[0]));
    }

    private static Language getLanguageByName(String name) throws Exception {
        switch (name.toLowerCase()) {
            case "java":
                return new Language("Java", OOP.class, StrongTyped.class);
            case "js":
            case "javascript":
                return new Language("JavaScript", MultiParadigm.class, DynamicTyped.class);
            case "python":
                return new Language("Python", MultiParadigm.class, DynamicTyped.class);
            case "haskell":
                return new Language("Haskell", Functional.class, StrongTyped.class);
            default:
                return new Language(name, Unknown.class, Unknown.class);
        }
    }

    private static void printLanguageDescription(Language language) {
        System.out.println(language.getDescription());
    }
}
