package account;

import people.User;

import java.util.Objects;

public class JointAccount extends AbstractAccount {
    private final User holder1;
    private final User holder2;

    public JointAccount(User holder1, User holder2){
        super();
        assert holder1 != null && holder2 != null : "Invalid users.";
        this.holder1 = holder1;
        this.holder2 = holder2;
    }

    public User getHolder() {
        return this.holder1;
    }
    public User[] getHolders(){
        return new User[] {this.holder1, this.holder2};
    }

    public IndividualAccount toIndividualAccount(String id1, String password1, String id2, String password2, User newHolder){
        assert Objects.equals(id1, this.holder1.getId()) && Objects.equals(password1, this.holder1.getPassword())
                && Objects.equals(id2, this.holder2.getPassword()) && Objects.equals(password2, this.holder2.getPassword())
                : "Wrong credentials.";
        assert newHolder.equals(this.holder1) || newHolder.equals(this.holder2) : "New holder must be one of the two current joint holders.";
        return IndividualAccount.fromJoint(this, newHolder);
    }
}
