package bank.synchronization.lowlevel;

import java.util.Random;

public class BankUser implements Runnable {
    private static final int MAX_MONEY_PER_TRANSFER = 100;
    private static final int TIME_TO_SLEEP = 10;
    private final Bank bank;
    private Random randomMoneyAmount;

    public BankUser(Bank bank) {
        this.bank = bank;
        this.randomMoneyAmount = new Random();
    }

    @Override
    public void run() {
        int moneyAmount;
        while (bank.getMoneyAmount() > 0) {
            synchronized (bank) {
                moneyAmount = randomMoneyAmount.nextInt(MAX_MONEY_PER_TRANSFER) + 1;
                if (bank.hasEnoughMoney(moneyAmount)) {
                    //sleep, чтобы спровоцировать ошибку
                    try {
                        Thread.sleep(TIME_TO_SLEEP);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bank.transferMoney(moneyAmount, Thread.currentThread().getId());
                    //yield, чтобы чаще переключаться на другие нити
                    Thread.yield();
                }
            }
        }
    }
}
