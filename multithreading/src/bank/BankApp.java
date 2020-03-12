package bank;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        new Thread(new BankUser(bank)).start();
        new Thread(new BankUser(bank)).start();


    }
}
