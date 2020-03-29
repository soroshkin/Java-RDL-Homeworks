package Factory.transport;

public class RoadTransport extends ATransport {
    @Override
    public void answer() {
        System.out.println("Road transport");
    }

    @Override
    public void deliver() {
        System.out.println("freight is delivered by road transport");
    }
}
