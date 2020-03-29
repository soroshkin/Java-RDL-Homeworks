package State.states;

import State.ICoffeeMachine;

import static State.states.Messages.*;

public class DeliverCoffeeState implements CoffeeMachineState {
    private ICoffeeMachine coffeeMachine;

    @Override
    public ICoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public DeliverCoffeeState(ICoffeeMachine coffeeMachine) {
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
        System.out.println("Take your coffee, please");
        coffeeMachine.changeState(new DispenseChangeState(coffeeMachine));
    }

    @Override
    public void giveChange(int moneyAmount) {
        coffeeMachine.dispatchError(COFFEE_IS_PREPARING_MESSAGE.getMessage());
    }
}
