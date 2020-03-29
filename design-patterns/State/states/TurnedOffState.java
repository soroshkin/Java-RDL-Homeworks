package State.states;

import State.ICoffeeMachine;

public class TurnedOffState implements CoffeeMachineState{
    private ICoffeeMachine coffeeMachine;

    @Override
    public ICoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public TurnedOffState(ICoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void deposit(int moneyAmount) {
    }

    @Override
    public void prepareCoffee() {
    }

    @Override
    public void deliverCoffee() {
    }

    @Override
    public void giveChange(int moneyAmount) {
    }

    @Override
    public void turnOn() {
        System.out.printf("%s is on duty%n", this);
        coffeeMachine.changeState(new ReadyToWorkState(coffeeMachine));
    }

    @Override
    public void turnOff() {
    }
}
