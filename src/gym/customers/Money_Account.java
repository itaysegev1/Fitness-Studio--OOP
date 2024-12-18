package gym.customers;

public class Money_Account {
    private int balance;

    public Money_Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void addMoney(int amount) {
        balance += amount;
    }

    public void subMoney(int amount) {
        balance -= amount;
    }

}
