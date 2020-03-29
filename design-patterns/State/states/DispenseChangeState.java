package State.states;

import State.ICoffeeMachine;

import static State.states.Messages.*;

public class DispenseChangeState implements CoffeeMachineState {
    private ICoffeeMachine coffeeMachine;

    @Override
    public ICoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public DispenseChangeState(ICoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void deposit(int moneyAmount) {
        coffeeMachine.dispatchError(COFFEE_IS_PREPARING_MESSAGE.getMessage());
    }

    @Override
    public void prepareCoffee() {
        coffeeMachine.dispatchError(COFFEE_IS_PREPARING_MESSAGE.getMessage());
    }

    @Override
    public void deliverCoffee() {
        coffeeMachine.dispatchError(COFFEE_IS_PREPARING_MESSAGE.getMessage());
    }

    @Override
    public void giveChange(int moneyAmount) {
        System.out.printf("Take your change: %d$, please%n", moneyAmount);
        coffeeMachine.changeState(new ReadyToWorkState(coffeeMachine));
    }
}
