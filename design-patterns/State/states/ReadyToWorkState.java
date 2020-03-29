package State.states;

import State.ICoffeeMachine;

import static State.states.Messages.INSERT_COIN;

public class ReadyToWorkState implements CoffeeMachineState {
    private ICoffeeMachine coffeeMachine;

    @Override
    public ICoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public ReadyToWorkState(ICoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void deposit(int moneyAmount) {
        System.out.printf("Got %d$, wait for your coffee%n", moneyAmount);
        coffeeMachine.changeState(new PrepareCoffeeState(coffeeMachine));
    }

    @Override
    public void prepareCoffee() {
        coffeeMachine.dispatchError(INSERT_COIN.getMessage());
    }

    @Override
    public void deliverCoffee() {
        coffeeMachine.dispatchError(INSERT_COIN.getMessage());
    }

    @Override
    public void giveChange(int moneyAmount) {
        coffeeMachine.dispatchError(INSERT_COIN.getMessage());
    }

    @Override
    public void turnOn() {
        System.out.println("Coffee machine is already on duty");
    }
}
