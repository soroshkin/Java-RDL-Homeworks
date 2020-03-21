package io.humb1t.deprecated;

public class NonDeprecatedClassFromInterface implements DeprecatedClassInterface{

    public void printSuggestion(String message){
        System.out.println(message);
    }
}
