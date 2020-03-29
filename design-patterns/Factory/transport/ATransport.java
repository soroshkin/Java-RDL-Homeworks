package Factory.transport;

import Factory.EmptyTransportException;
import Factory.products.IProduct;

public abstract class ATransport implements ITransport {
    IProduct product;

       @Override
    public void putProduct(IProduct product) {
        this.product = product;
        System.out.println("put " + product);
    }

    @Override
    public IProduct getProduct() throws EmptyTransportException {
        if (product != null) {
            return product;
        } else {
            throw new EmptyTransportException("no product available");
        }
    }
}
