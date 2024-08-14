package src;

public class IndividualAccount extends AbstractAccount {
    private final Person holder;

    public IndividualAccount(Person holder){
        super();
        this.holder = holder;
    }
}
