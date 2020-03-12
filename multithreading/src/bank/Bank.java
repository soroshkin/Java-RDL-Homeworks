package bank;

public class Bank {
    private int moneyAmount;

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void transferMoney(int amount) {
        if (!hasEnoughMoney(amount)) {
            throw new NotEnoughMoneyException("not enough money");
        }
        moneyAmount -= amount;
        System.out.println(amount + " dollars transferred by user-" + Thread.currentThread().getId() + " " + moneyAmount + " dollars left in Bank");
    }

    public boolean hasEnoughMoney(int amount) {
        return moneyAmount >= amount;
    }
}
