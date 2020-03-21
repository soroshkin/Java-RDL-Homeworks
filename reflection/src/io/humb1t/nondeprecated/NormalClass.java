package io.humb1t.nondeprecated;

public class NormalClass {
    private int number;

    public NormalClass(int number) {
        this.number = number;
    }

    public void print(String message){
        System.out.println(this + " prints " + message);
    }

    @Override
    public String toString() {
        return "NormalClass{" +
                "number=" + number +
                '}';
    }
}
