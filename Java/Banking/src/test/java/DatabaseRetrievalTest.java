import account.Account;
import account.IndividualAccount;
import account.JointAccount;
import account.ParentalAccount;
import database.DatabaseInsert;
import database.DatabaseOperation;
import database.DatabaseRetrieve;
import operations.Login;
import org.junit.jupiter.api.Test;
import database.DatabaseConnection;
import people.Person;
import people.User;
import utility.SimpleDate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
public class DatabaseRetrievalTest {

    @Test
    public void testUserEmailRetrieve() {
        User u = DatabaseRetrieve.retrieveUserEmail("ilaiavron@gmail.com", "Affan123");
        System.out.println(u);
    }
}
