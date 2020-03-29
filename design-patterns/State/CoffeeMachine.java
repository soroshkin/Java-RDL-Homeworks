package State;

import State.states.CoffeeMachineState;
import State.states.ReadyToWorkState;
import State.states.TurnedOffState;

public class CoffeeMachine implements ICoffeeMachine {
    private CoffeeMachineState state;
    private int money;

    public void changeState(CoffeeMachineState state) {
        this.state = state;
    }

    @Override
    public void deposit(int moneyAmount) {
        this.money += moneyAmount;
        state.deposit(moneyAmount);
    }

    @Override
    public void prepareCoffee() {
        state.prepareCoffee();
    }

    @Override
    public void deliverCoffee() {
        state.deliverCoffee();
    }

    @Override
    public void giveChange(int moneyAmount) {
        this.money -= moneyAmount;
        state.giveChange(moneyAmount);
    }

    @Override
    public void dispatchError(String message) {
        System.out.println(message);
    }

    @Override
    public void init() {
        System.out.println("Coffee machine is turned on");
        state = new ReadyToWorkState(this);
    }

    @Override
    public void stop() {
        System.out.println("Coffee machine stopped");
        state = new TurnedOffState(this);
    }
}


