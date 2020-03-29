package Factory.transport;

import Factory.EmptyTransportException;
import Factory.products.IProduct;

// абстрактный транспорт
public interface ITransport {
    void answer(); // передает статус (например, свой id или имя и координаты)
    void deliver(); // доставить груз
    void putProduct(IProduct product); // загрузить груз
    IProduct getProduct() throws EmptyTransportException; // получить груз
}
