package Factory;

import Factory.factories.FreightFactory;
import Factory.transport.ITransport;
import Factory.transport.Transports;

public class TransportSystem {
    public static void main(String[] args) {
        FreightFactory freightFactory = new FreightFactory();

        try {
            ITransport airTransport = freightFactory.createTransport(Transports.AIR_TRANSPORT);
            ITransport railwayTransport = freightFactory.createTransport(Transports.RAILWAY_TRANSPORT);
            ITransport seaTransport = freightFactory.createTransport(Transports.SEA_TRANSPORT);
            ITransport roadTransport = freightFactory.createTransport(Transports.ROAD_TRANSPORT);

            airTransport.deliver();
            railwayTransport.deliver();
            seaTransport.deliver();
            roadTransport.deliver();
        } catch (NoSuchTransportException e) {
            e.printStackTrace();
        }
    }
}
