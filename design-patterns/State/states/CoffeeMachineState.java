package State.states;

import State.ICoffeeMachine;

public interface CoffeeMachineState {
    void deposit(int moneyAmount); // принять деньги

    void prepareCoffee(); // приготовить кофе

    void deliverCoffee(); // выдать кофе клиенту

    void giveChange(int moneyAmount); // отдать сдачу

    ICoffeeMachine getCoffeeMachine();

    default void turnOn() {
        System.out.printf("%s is already on duty%n", this);
        ICoffeeMachine coffeeMachine = getCoffeeMachine();
        coffeeMachine.changeState(new ReadyToWorkState(coffeeMachine));
    }

    default void turnOff() {
        ICoffeeMachine coffeeMachine = getCoffeeMachine();
        System.out.println(coffeeMachine + " turned off");
        coffeeMachine.changeState(new TurnedOffState(coffeeMachine));
    }
}
