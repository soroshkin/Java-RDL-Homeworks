package Factory.products;

public class Brick implements IProduct {
    private double weight;
    private double size;

    public Brick(double weight, double size) {
        this.weight = weight;
        this.size = size;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getSize() {
        return size;
    }
}
