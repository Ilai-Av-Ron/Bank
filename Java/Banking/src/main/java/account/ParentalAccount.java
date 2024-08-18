package account;

import lombok.Getter;
import people.User;

import java.util.Objects;

public class ParentalAccount extends BaseAccount {
    private final User child;
    @Getter
    private User guardian;

    public ParentalAccount(User child, User guardian){
        super();
        this.child = child;
        this.guardian = guardian;
    }

    public User getHolder(){
        return this.child;
    }

    public void setGuardian(User guardian, String id, String password) {
        assert Objects.equals(id, this.guardian.getId()) && Objects.equals(this.guardian.getPassword(), password) : "Wrong guardian user credentials.";
        this.guardian = guardian;
    }

    public IndividualAccount toIndividual(String id, String password){
        assert !this.child.isMinor() : "Must be over 18 to transfer to an individual account";
        assert Objects.equals(id, this.child.getId()) && Objects.equals(this.child.getPassword(), password) : "Wrong user credentials.";
        return IndividualAccount.fromParental(this);

    }
}
