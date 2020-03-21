package io.humb1t.controller;

import io.humb1t.helpers.ConsoleHelper;
import io.humb1t.nondeprecated.NormalClass;
import io.humb1t.deprecated.DeprecatedChildOfParent;
import io.humb1t.exceptions.NoSuchClassException;

public class HomeworkMain {
    public static void main(String[] args) {
        Object[] arrayOfObjects = createArrayOfObject();

        SubClassesSearchEngine searchEngine = new SubClassesSearchEngine();
        for (Object objectToInspect : searchEngine.filterDeprecatedClasses(arrayOfObjects)) {
            Class<?>[] interfaces = objectToInspect.getClass().getInterfaces();
            if (interfaces.length > 0) {
                for (Class<?> interfaceOfClass : interfaces) {
                    ConsoleHelper.printSuggestionMessage(searchEngine.scanInAllPackages(interfaceOfClass, objectToInspect), objectToInspect);
//                 uncomment to use Reflections Library
//                    ConsoleHelper.printSuggestionMessage(searchEngine.findNonDeprecatedSubClassesWithReflectionsLibrary(interfaceOfClass), objectToInspect);
                }
            }
            try {
                Class<?> superClass = searchEngine.findNonDeprecatedSuperClass(objectToInspect);
                ConsoleHelper.printSuggestionMessage(searchEngine.scanInAllPackages(superClass, objectToInspect), objectToInspect);
//                uncomment to use Reflections Library
//                ConsoleHelper.printSuggestionMessage(searchEngine.findNonDeprecatedSubClassesWithReflectionsLibrary(superClass), objectToInspect);
            } catch (NoSuchClassException e) {
                System.err.println(e);
            }
        }
    }

    public static Object[] createArrayOfObject() {
        Object[] arrayOfObjects = new Object[2];

        for (int i = 0; i < arrayOfObjects.length; i++) {
            if (i % 2 == 0) {
                arrayOfObjects[i] = new DeprecatedChildOfParent("deprecated class" + i);
            } else {
                arrayOfObjects[i] = new NormalClass(i);
            }
        }
        return arrayOfObjects;
    }
}
