package src.account;

import lombok.Getter;
import src.people.User;

import java.util.UUID;

public class IndividualAccount extends AbstractAccount {
    @Getter
    private final User holder;

    public IndividualAccount(User holder){
        super();
        this.holder = holder;
    }

    private IndividualAccount(User holder, UUID accountNumber, double balance){
        super(accountNumber, balance);
        this.holder = holder;
    }

    public static IndividualAccount fromJoint(JointAccount account, User holder){
        return new IndividualAccount(holder, account.getAccountNumber(), account.getBalance());
    }

    public static IndividualAccount fromParental(ParentalAccount account){
        return new IndividualAccount(account.getHolder(), account.getAccountNumber(), account.getBalance());
    }
}
