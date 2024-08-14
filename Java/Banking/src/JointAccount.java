package src;

public class JointAccount extends AbstractAccount {
    private final User holder1;
    private final User holder2;

    public JointAccount(User holder1, User holder2){
        super();
        this.holder1 = holder1;
        this.holder2 = holder2;
    }

    public User[] getHolders(){
        return new User[] {this.holder1, this.holder2};
    }
}
