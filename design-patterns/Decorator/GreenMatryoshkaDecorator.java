package Decorator;

public class GreenMatryoshkaDecorator extends MatryoshkaDecorator {
    public GreenMatryoshkaDecorator(AMatryoshka matryoshka) {
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
        return " paint matryoshka in green";
    }

}
