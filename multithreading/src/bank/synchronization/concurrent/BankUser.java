package bank.synchronization.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BankUser implements Runnable {
    private static final int MAX_MONEY_PER_TRANSFER = 100;
    private static final int TIME_TO_SLEEP = 5;
    private static final Semaphore SEMAPHORE = new Semaphore(1);

    private Bank bank;
    private Random randomMoneyAmount;


    public BankUser(Bank bank) {
        this.bank = bank;
        this.randomMoneyAmount = new Random();
    }

    @Override
    public void run() {
        try {
            askMoney();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void askMoney() throws InterruptedException {
        int moneyAmount;
        while (bank.getMoneyAmount() > 0) {
            SEMAPHORE.acquire();
            moneyAmount = randomMoneyAmount.nextInt(MAX_MONEY_PER_TRANSFER) + 1;
            if (bank.hasEnoughMoney(moneyAmount)) {
                //вызываю засыпание нити, чтобы спровоцировать ошибку
                Thread.sleep(TIME_TO_SLEEP);
                bank.transferMoney(moneyAmount, Thread.currentThread().getId());
            }
            SEMAPHORE.release();
            //задержка для более четкого переключения между нитями
            Thread.sleep(TIME_TO_SLEEP);
        }
    }
}
