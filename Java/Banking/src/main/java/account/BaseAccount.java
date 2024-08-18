package account;

import lombok.Getter;
import utility.SimpleDate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Getter
public class BaseAccount implements account.Account {
    protected final UUID accountNumber;
    protected double balance;
    protected final SimpleDate dateCreated;
    protected String accountType = null;

    public BaseAccount(){
        this.balance = 0;
        UUID accountNumber = UUID.randomUUID();
        while (!validateAccountNumber(accountNumber)){
            accountNumber = UUID.randomUUID();
        }
        this.accountNumber = accountNumber;
        this.dateCreated = SimpleDate.today();
    }

    public BaseAccount(UUID accountNumber, double balance, SimpleDate dateCreated, String accountType){
        assert validateAccountNumber(accountNumber) : "Not a valid account number";
        assert dateCreated.before(SimpleDate.today()) : "Creation date must be earlier than today.";
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dateCreated = dateCreated;
        this.accountType = accountType;
    }
    public BaseAccount(ResultSet res) throws SQLException {
        this(
                UUID.fromString(res.getString("account_id")),
                res.getDouble("balance"),
                new SimpleDate(res.getDate("created_at").getYear() + 1900, res.getDate("created_at").getMonth() + 1, res.getDate("created_at").getDate()),
                res.getString("account_type")
        );
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

    @Override
    public String toString() {
        return "BaseAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
