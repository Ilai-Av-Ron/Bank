import account.Account;
import account.IndividualAccount;
import account.ParentalAccount;
import database.DatabaseInsert;
import org.junit.jupiter.api.Test;
import database.DatabaseConnection;
import people.Person;
import people.User;
import utility.SimpleDate;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseInsertionTest {
    Person ilai = new Person("318918547", "Ilai", "Av-Ron", 3000, new SimpleDate(1999, 2, 1), "Tel Aviv, Israel", false);
    Person danco = new Person("208384938", "Daniel", "Av-Ron", 100, new SimpleDate(2010, 8, 25), "Tel Aviv, Israel", false);
    User ilai_user = new User("318918547", "Ilai", "Av-Ron", 3000, new SimpleDate(1999, 2, 1), "Tel Aviv, Israel", false, "ilaiavron@gmail.com", "Affan123");
    User danco_user = new User("208384938", "Daniel", "Av-Ron", 100, new SimpleDate(2010, 8, 25), "Tel Aviv, Israel", false, "dancodaniel1@gmail.com", "Roktavor123");
    User aviva = new User("303192482", "Aviva", "Soesman", 5000, new SimpleDate(1956, 7, 10), "Tel Aviv, Israel", true, "avivasoes@tau.co.il", "Toussaint123");


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
}
