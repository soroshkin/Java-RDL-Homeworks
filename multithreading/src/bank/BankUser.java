package bank;

import java.util.Random;

public class BankUser implements Runnable {
    Bank bank;

    public BankUser(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        Random randomMoneyAmount = new Random();
        while (!Thread.currentThread().isInterrupted()) {
            int moneyAmount = randomMoneyAmount.nextInt(10) + 1;
            //  System.out.println(moneyAmount);
            if (bank.hasEnoughMoney(moneyAmount)) {
                bank.transferMoney(moneyAmount);
            } else {
                Thread.currentThread().interrupt();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
