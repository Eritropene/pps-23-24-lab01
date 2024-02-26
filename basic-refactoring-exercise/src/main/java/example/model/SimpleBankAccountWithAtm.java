package example.model;

public class SimpleBankAccountWithAtm implements BankAccount{

    private final double transactionFee;
    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance, final double transactionFee) {
        this.holder = holder;
        this.balance = balance;
        this.transactionFee = transactionFee;
    }
    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (verifyUser(userID) && allowDeposit(amount)) {
            this.balance = this.balance + amount - this.transactionFee;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (verifyUser(userID) && allowWithdraw(amount)) {
            this.balance = this.balance - amount - this.transactionFee;
        }
    }

    private boolean verifyUser(final int userID) {
        return this.holder.getId() == userID;
    }

    private boolean allowWithdraw(final double amount) {
        return amount > 0 && this.balance >= amount + this.transactionFee;
    }

    private boolean allowDeposit(final double amount) {
        return amount > 0 && amount > this.transactionFee;
    }
}
