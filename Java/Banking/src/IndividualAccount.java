package src;

import java.util.UUID;

public class IndividualAccount extends AbstractAccount {
    private final User holder;

    public IndividualAccount(User holder){
        super();
        this.holder = holder;
    }

    private IndividualAccount(User holder, UUID accountNumber, double balance){
        super(accountNumber, balance);
        this.holder = holder;
    }

    public IndividualAccount fromJoint(JointAccount account, User holder){
        assert holder == account.getHolders()[0] || holder == account.getHolders()[0] : "New holder must be one of the two previous holders.";
        return new IndividualAccount(holder, account.getAccountNumber(), account.getBalance());
    }

    public User getHolder(){
        return this.holder;
    }
}
