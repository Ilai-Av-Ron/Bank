package database;

import lombok.Getter;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;


public class DatabaseConnection {
    @Getter
    private static Connection connection = null;

    static {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
            } else {
                prop.load(input);

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.username");
                String password = prop.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established successfully.");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Error: Integrity constraint violation - " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Error: Timeout occurred - " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Non-SQL Error: " + e.getMessage());
        }
    }
}
