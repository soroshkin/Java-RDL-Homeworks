package Factory.transport;

public class SeaTransport extends ATransport {
    @Override
    public void answer() {
        System.out.println("Sea transport");
    }

    @Override
    public void deliver() {
        System.out.println("freight is delivered by sea transport");
    }
}
