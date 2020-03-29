package State;

import State.states.CoffeeMachineState;

public interface ICoffeeMachine {
    void changeState(CoffeeMachineState state);

    void deposit(int moneyAmount); // принять деньги

    void prepareCoffee(); // приготовить кофе

    void deliverCoffee(); // выдать кофе клиенту

    void giveChange(int moneyAmount); // отдать сдачу

    void dispatchError(String message); // обработчик ошибок (например написать сообщение об ошибке клиенту)

    void init(); // инициализация

    void stop(); // остановить и больше не принимать команды
}
