package account;

import lombok.Getter;
import utility.SimpleDate;

import java.util.UUID;

@Getter
public abstract class AbstractAccount implements account.Account {
    protected final UUID accountNumber;
    protected double balance;
    protected final SimpleDate dateCreated;

    public AbstractAccount(){
        this.balance = 0;
        UUID accountNumber = UUID.randomUUID();
        while (!validateAccountNumber(accountNumber)){
            accountNumber = UUID.randomUUID();
        }
        this.accountNumber = accountNumber;
        this.dateCreated = SimpleDate.today();
    }

    public AbstractAccount(UUID accountNumber, double balance, SimpleDate dateCreated){
        assert validateAccountNumber(accountNumber) : "Not a valid account number";
        assert dateCreated.before(SimpleDate.today()) : "Creation date must be earlier than today.";
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dateCreated = dateCreated;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public boolean validateAccountNumber(UUID accountNumber){
        return true;
    }
}
