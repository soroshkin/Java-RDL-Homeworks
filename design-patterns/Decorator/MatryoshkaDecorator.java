package Decorator;

public class MatryoshkaDecorator extends AMatryoshka {
    AMatryoshka matryoshka;

    public MatryoshkaDecorator(AMatryoshka matryoshka) {
        this.matryoshka = matryoshka;
    }

    @Override
    public String assemble() {
        return matryoshka.assemble();
    }

    @Override
    public String disassemble() {
       return matryoshka.disassemble();
    }
}

