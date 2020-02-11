package Factory;

// абстрактный транспорт
public interface ITransport {
    void answer(); // передает статус (например, свой id или имя и координаты)
    void deliver(); // доставить груз
    void putProduct(IProduct product); // загрузить груз
    IProduct getProduct(); // получить груз
}
