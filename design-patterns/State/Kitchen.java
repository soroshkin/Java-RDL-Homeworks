package State;

public class Kitchen {
    public static void main(String[] args) {
        ICoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.init();
        coffeeMachine.prepareCoffee();
        coffeeMachine.deposit(100);
        coffeeMachine.prepareCoffee();
        coffeeMachine.deposit(100);
        coffeeMachine.deliverCoffee();
        coffeeMachine.giveChange(2);
        coffeeMachine.stop();
        coffeeMachine.deliverCoffee();
    }
}
