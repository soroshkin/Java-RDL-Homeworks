package io.humb1t.controller;

import io.humb1t.exceptions.NoSuchClassException;
import org.reflections.Reflections;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SubClassesSearchEngine {
    public List<Object> filterDeprecatedClasses(Object[] array) {
        return Arrays.stream(array)
                .filter(object -> object.getClass().isAnnotationPresent(Deprecated.class))
                .collect(Collectors.toList());
    }

    //my own implementation
    public Set<?> scanInAllPackages(Class<?> interfaceOrSuperClass, Object deprecatedClass) {
        Set<Object> setOfSubClasses = new HashSet<>();
        for (Package aPackage : Package.getPackages()) {
            try {
                setOfSubClasses.addAll(findNonDeprecatedSubClasses(interfaceOrSuperClass, aPackage.getName(), deprecatedClass));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return setOfSubClasses;
    }

    public Collection<Object> findNonDeprecatedSubClasses(Class<?> interfaceOrSuperClass, String packageName, Object deprecatedClass) throws URISyntaxException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
        if (url == null || url.getProtocol().equalsIgnoreCase("jar")) {
            return Collections.emptySet();
        }
        Path root = Paths.get(url.toURI());
        String regex = ".class";

        return Arrays.stream(Objects.requireNonNull(new File(root.toString()).listFiles()))
                .filter(file -> file.isFile()
                        && file.getName().endsWith(regex))
                .map(file -> {
                    try {
                        return Class.forName(packageName + "." + file.getName().replaceAll(regex, ""));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        return Class.class;
                    }
                })
                .filter(clazz -> interfaceOrSuperClass.isAssignableFrom(clazz)
                        && interfaceOrSuperClass != clazz
                        && !clazz.isAnnotationPresent(Deprecated.class)
                        && deprecatedClass.getClass() != clazz
                )
                .collect(Collectors.toSet());
    }

    //using Reflections library
    public Set<?> findNonDeprecatedSubClassesWithReflectionsLibrary(Class<?> interfaceOrSuperClass) {
        Reflections reflections = new Reflections();
        return reflections.getSubTypesOf(interfaceOrSuperClass)
                .stream()
                .filter(clazz -> !clazz.isAnnotationPresent(Deprecated.class))
                .collect(Collectors.toSet());
    }

    public Class<?> findNonDeprecatedSuperClass(Object object) throws NoSuchClassException {
        Class<?> superClass = object.getClass().getSuperclass();
        if (superClass != null
                && superClass != Object.class
                && !superClass.isAnnotationPresent(Deprecated.class)) {
            return superClass;
        } else {
            throw new NoSuchClassException("Class " + object + " doesn't have non-deprecated super classes (except Object class)");
        }
    }
}
