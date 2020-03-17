package bank.synchronization.lowlevel;

public class BankApp {
    private static final int NUMBER_OF_BANK_USERS = 5;

    public static void main(String[] args) {

        Bank bank = new Bank(10000);
        for (int i = 0; i < NUMBER_OF_BANK_USERS; i++) {
            new Thread(new BankUser(bank)).start();
        }
    }
}
