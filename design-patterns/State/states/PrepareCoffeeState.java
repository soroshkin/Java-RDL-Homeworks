package State.states;

import State.ICoffeeMachine;
import static State.states.Messages.*;

public class PrepareCoffeeState implements CoffeeMachineState {
    private ICoffeeMachine coffeeMachine;

    @Override
    public ICoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public PrepareCoffeeState(ICoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void deposit(int moneyAmount) {
        coffeeMachine.dispatchError(COFFEE_IS_PREPARING_MESSAGE.getMessage());
    }

    @Override
    public void prepareCoffee() {
        System.out.println(COFFEE_IS_PREPARING_MESSAGE.getMessage());
        coffeeMachine.changeState(new DeliverCoffeeState(coffeeMachine));
    }

    @Override
    public void deliverCoffee() {
        coffeeMachine.dispatchError(COFFEE_MACHINE_IS_BUSY_MESSAGE.getMessage());
    }

    @Override
    public void giveChange(int moneyAmount) {
        coffeeMachine.dispatchError(COFFEE_MACHINE_IS_BUSY_MESSAGE.getMessage());
    }
}
