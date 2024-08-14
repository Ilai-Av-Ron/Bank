package src;

import java.util.UUID;

public class AbstractAccount implements Account {
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
