package Decorator;

public class RedMatryoshkaDecorator extends MatryoshkaDecorator {
    public RedMatryoshkaDecorator(AMatryoshka matryoshka) {
        super(matryoshka);
    }

    @Override
    public String assemble() {
        return super.assemble() + changeColor();
    }

    @Override
    public String disassemble() {
        return super.disassemble() + changeColor();
    }

    public String changeColor() {
        return " paint in red";
    }
}
