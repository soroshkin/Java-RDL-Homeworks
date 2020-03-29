package Decorator;

public class BigMatryoshkaDecorator extends MatryoshkaDecorator {
    public BigMatryoshkaDecorator(AMatryoshka matryoshka) {
        super(matryoshka);
    }

    @Override
    public String assemble() {
        return super.assemble() + changeSize();
    }

    @Override
    public String disassemble() {
        return super.disassemble() + changeSize();
    }

    public String changeSize() {
        return " make it big";
    }
}
