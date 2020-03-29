package Decorator;

public class BlueMatryoshkaDecorator extends MatryoshkaDecorator {
    public BlueMatryoshkaDecorator(AMatryoshka matryoshka) {
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
        return " paint in blue";
    }
}
