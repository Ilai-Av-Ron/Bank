package src;

import java.util.UUID;

public abstract class AbstractAccount implements Account {
    protected final UUID accountNumber;
    protected double balance;

    public AbstractAccount(){
        this.balance = 0;
        UUID accountNumber = UUID.randomUUID();
        while (!validateAccountNumber(accountNumber)){
            accountNumber = UUID.randomUUID();
        }
        this.accountNumber = accountNumber;
    }

    protected AbstractAccount(UUID accountNumber, double balance){
        assert accountNumber != null : "Not a valid account number";
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public UUID getAccountNumber() {
        return this.accountNumber;
    }

    public boolean validateAccountNumber(UUID accountNumber){
        return true;
    }
}
