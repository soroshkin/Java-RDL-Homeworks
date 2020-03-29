package Factory.factories;

import Factory.NoSuchTransportException;
import Factory.transport.*;

public class FreightFactory {
    public ITransport createTransport(Transports transportName) throws NoSuchTransportException {
        switch (transportName) {
            case AIR_TRANSPORT:
                return new AirTransport();
            case ROAD_TRANSPORT:
                return new RoadTransport();
            case RAILWAY_TRANSPORT:
                return new RailwayTransport();
            case SEA_TRANSPORT:
                return new SeaTransport();
            default:
                throw new NoSuchTransportException("there is no such transport " + transportName.name());
        }
    }
}