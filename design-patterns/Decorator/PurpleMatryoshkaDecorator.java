package Decorator;

public class PurpleMatryoshkaDecorator extends MatryoshkaDecorator {
    public PurpleMatryoshkaDecorator(AMatryoshka matryoshka) {
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
        return " paint in purple";
    }

}
