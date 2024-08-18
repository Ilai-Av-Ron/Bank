package account;

import lombok.Getter;
import people.User;
import utility.SimpleDate;

import java.util.UUID;

@Getter
public class IndividualAccount extends BaseAccount {
    private final User holder;

    public IndividualAccount(User holder){
        super();
        this.holder = holder;
    }

    private IndividualAccount(User holder, UUID accountNumber, double balance, SimpleDate dateCreated){
        super(accountNumber, balance, dateCreated, "individual_account");
        this.holder = holder;
    }

    public static IndividualAccount fromJoint(JointAccount account, User holder){
        return new IndividualAccount(holder, account.getAccountNumber(), account.getBalance(), account.getDateCreated());
    }

    public static IndividualAccount fromParental(ParentalAccount account){
        return new IndividualAccount(account.getHolder(), account.getAccountNumber(), account.getBalance(), account.getDateCreated());
    }
}
