package Factory.transport;

public class RailwayTransport extends ATransport {
    @Override
    public void answer() {
        System.out.println("Railway transport");
    }

    @Override
    public void deliver() {
        System.out.println("freight is delivered by railway transport");
    }
}
