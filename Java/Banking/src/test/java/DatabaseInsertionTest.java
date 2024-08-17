import account.Account;
import account.IndividualAccount;
import account.JointAccount;
import account.ParentalAccount;
import database.DatabaseInsert;
import database.DatabaseOperation;
import org.junit.jupiter.api.Test;
import database.DatabaseConnection;
import people.Person;
import people.User;
import utility.SimpleDate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseInsertionTest {
    Person ilai = new Person("318918547", "Ilai", "Av-Ron", 3000, new SimpleDate(1999, 2, 1), "Tel Aviv, Israel", false);
    Person danco = new Person("208384938", "Daniel", "Av-Ron", 100, new SimpleDate(2010, 8, 25), "Tel Aviv, Israel", false);
    User ilai_user = new User("318918547", "Ilai", "Av-Ron", 3000, new SimpleDate(1999, 2, 1), "Tel Aviv, Israel", false, "ilaiavron@gmail.com", "Affan123");
    User danco_user = new User("208384938", "Daniel", "Av-Ron", 100, new SimpleDate(2010, 8, 25), "Tel Aviv, Israel", false, "dancodaniel1@gmail.com", "Roktavor123");
    User aviva = new User("303192482", "Aviva", "Soesman", 5000, new SimpleDate(1956, 7, 10), "Tel Aviv, Israel", true, "avivasoes@tau.co.il", "Toussaint123");
    User daddy = new User("207823958", "Uriah", "Av-Ron", 10000, new SimpleDate(1968, 11, 11), "Tel Aviv, Israel", true, "uraih@oasis.pr", "DaddyCanIHaveApple");
    IndividualAccount daddyAcc = new IndividualAccount(daddy);
    @Test
    public void testPersonInsertion() {
        DatabaseInsert.insertNewPerson(ilai);
        DatabaseInsert.insertNewPerson(danco);
    }

    @Test
    public void testUserInsertion() {
        DatabaseInsert.insertNewUser(ilai_user);
        DatabaseInsert.insertNewUser(danco_user);
    }

    @Test
    public void testIndividualAccountInsertion() {
        IndividualAccount ilaiAcc = new IndividualAccount(ilai_user);
        DatabaseInsert.insertNewIndividualAccount(ilaiAcc);
    }

    @Test
    public void testParentalAccountInsertion() {
        ParentalAccount dancos = new ParentalAccount(danco_user, aviva);
        DatabaseInsert.insertNewParentalAccount(dancos);
    }

    @Test
    public void testJointAccountInsertion() {
        JointAccount inLove = new JointAccount(daddy, aviva);
        DatabaseInsert.insertNewJointAccount(inLove);
    }

    @Test
    public void testTransactionInsertion() {
        daddyAcc.withdraw(100000);
        DatabaseInsert.insertNewTransaction(daddyAcc, String.valueOf(UUID.randomUUID()), "withdrawal", 100000);
        daddyAcc.deposit(880000);
        DatabaseInsert.insertNewTransaction(daddyAcc, String.valueOf(UUID.randomUUID()), "deposit", 880000);
    }
}
