package io.humb1t.deprecated;

@java.lang.Deprecated
public class DeprecatedChildOfParent extends Parent implements DeprecatedClassInterface {
    private String name;

    public DeprecatedChildOfParent(String name) {
        this.name = name;
    }

    public void action(int number) {
    }

    private int countEquation(Integer x, Integer y) {
        return x + y;
    }
}
