package Factory.transport;

public class AirTransport extends ATransport{
    @Override
    public void answer() {
        System.out.println("Air transport");
    }

    @Override
    public void deliver() {
        System.out.println("freight is delivered by air transport");
    }
}
