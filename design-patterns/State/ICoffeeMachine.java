package State;

public interface ICoffeeMachine {
    void Deposit(int MoneyAmount); // принять деньги
    void PrepareCoffee(); // приготовить кофе
    void DeliverCoffee(); // выдать кофе клиенту
    void GiveChange(int MoneyAmount); // отдать сдачу

    void dispatchError(); // обработчик ошибок (например написать сообщение об ошибке клиенту)

    void init(); // инициализация
    void stop(); // остановить и больше не принимать команды
}
