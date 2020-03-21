package io.humb1t.helpers;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleHelper {

    public static void printSuggestionMessage(Set<?> subClasses, Object deprecatedClass){
        for (Object object: subClasses) {
            System.out.printf("Use %s class instead of %s class%n", ((Class<?>) object).getSimpleName(), deprecatedClass.getClass().getSimpleName());
        }
    }

    public static void printSuggestionMessage(Object object){
        printSuggestionMessage(Stream.of(object).collect(Collectors.toSet()), object);
    }
}
