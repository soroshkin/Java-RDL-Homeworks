package Decorator;

public class Matryoshka extends AMatryoshka {
    public Matryoshka(String name) {
        this.name = name;
    }

    @Override
    public String assemble() {
        return "assemble matryoshka";
    }

    @Override
    public String disassemble() {
        return "disassemble matryoshka";
    }
}
