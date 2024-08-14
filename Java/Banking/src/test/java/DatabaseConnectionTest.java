import org.junit.jupiter.api.Test;
import utility.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    @Test
    public void testConnectionNotNull() {
        Connection connection = DatabaseConnection.getConnection();
        assertNotNull(connection, "The database connection should not be null.");
    }

    @Test
    public void testConnectionIsValid() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            assertNotNull(connection, "The database connection should not be null.");
            assertTrue(connection.isValid(2), "The database connection should be valid.");
        } catch (SQLException e) {
            fail("An SQLException was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testConnectionClosed() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            assertNotNull(connection, "The database connection should not be null.");
            connection.close();
            assertTrue(connection.isClosed(), "The connection should be closed.");
        } catch (SQLException e) {
            fail("An SQLException was thrown: " + e.getMessage());
        }
    }
}
