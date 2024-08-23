import account.*;
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
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
public class DatabaseRetrievalTest {

    @Test
    public void testUserEmailRetrieve() throws SQLException {
        User u = new User(DatabaseRetrieve.retrieveUserEmail("ilaiavron@gmail.com", "Affan123"));
        System.out.println(u);
    }
    @Test
    public void testUserIdRetrieve() throws SQLException {
        User u = new User(DatabaseRetrieve.retrieveUserId("318918547", "Affan123"));
        System.out.println(u);
    }
//    @Test
//    public void testAccountsRetrieve() throws SQLException {
//        ArrayList<BaseAccount> userAccounts = Login.getUserAccounts("303192482");
//        System.out.println(userAccounts);
//    }
}
