package gym;

/**
 * In this class we implement a money account
 */
public class Money_Account {
    private int balance;

    /**
     * Constructs a Money_Account object with the specified initial balance.
     *
     * @param balance the initial balance for the account
     */
    public Money_Account(int balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the current balance of the account.
     *
     * @return the current balance as an integer.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Adds the specified amount of money to the account balance.
     *
     * @param amount the amount of money to be added to the balance
     */
    public void addMoney(int amount) {
        balance += amount;
    }

    /**
     * Subtracts a specified amount of money from the account balance.
     *
     * @param amount the amount of money to be subtracted from the balance
     */
    public void subMoney(int amount) {
        balance -= amount;
    }

}
