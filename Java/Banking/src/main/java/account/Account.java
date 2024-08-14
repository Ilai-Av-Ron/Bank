package account;

import java.util.UUID;

public interface Account {
    void deposit (double amount);
    void withdraw(double amount);
    double getBalance();
    UUID getAccountNumber();
}
