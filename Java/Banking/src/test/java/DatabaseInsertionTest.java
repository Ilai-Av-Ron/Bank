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

    @Test
    public void testPersonInsertion() {
        Person ilai = new Person("418918547", "Ilai", "Av-Ron", 3000, new SimpleDate(1999, 2, 1), "Tel Aviv, Israel", false);
        DatabaseInsert.insertNewPerson(ilai);
        Person danco = new Person("608384938", "Daniel", "Av-Ron", 100, new SimpleDate(2010, 8, 25), "Tel Aviv, Israel", false);
        DatabaseInsert.insertNewPerson(danco);

    }

    @Test
    public void testUserInsertion() {
        User ilai = new User("318918547", "Ilai", "Av-Ron", 3000, new SimpleDate(1999, 2, 1), "Tel Aviv, Israel", false, "ilaiavron@gmail.com", "Affan123");
        DatabaseInsert.insertNewUser(ilai);
        User danco = new User("208384938", "Daniel", "Av-Ron", 100, new SimpleDate(2010, 8, 25), "Tel Aviv, Israel", false, "dancodaniel1@gmail.com", "Roktavor123");
        DatabaseInsert.insertNewUser(danco);
    }
}
