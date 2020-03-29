package Decorator;

public class Main {
    public static void main(String[] args) {
        AMatryoshka matryoshka = new Matryoshka("simple");
        AMatryoshka blueMatryoshka = new BlueMatryoshkaDecorator(matryoshka);
        AMatryoshka purpleMatryoshka = new PurpleMatryoshkaDecorator(matryoshka);
        AMatryoshka anotherPurpleMatryoshka = new RedMatryoshkaDecorator(new BlueMatryoshkaDecorator(matryoshka));
        AMatryoshka bigRedMatryoshka = new BigMatryoshkaDecorator(new RedMatryoshkaDecorator(matryoshka));
        AMatryoshka bigGreenMatryoshka = new BigMatryoshkaDecorator(new GreenMatryoshkaDecorator(matryoshka));

        System.out.println(matryoshka.assemble());
        System.out.println(purpleMatryoshka.assemble());
        System.out.println("red + blue matryoshkas = purple matryoshka");
        System.out.println(anotherPurpleMatryoshka.assemble());
        System.out.println(bigRedMatryoshka.assemble());
        System.out.println(bigGreenMatryoshka.assemble());
        System.out.println(blueMatryoshka.assemble());

    }
}
