package database;

import java.sql.*;

public class DatabaseOperation {
    private final String SQLQuery;
    private final Connection conn;

    public DatabaseOperation(String SQLQuery){
        this.conn = DatabaseConnection.getConnection();
        this.SQLQuery = SQLQuery;
    }

    public void execute(){
        try {Statement stmt = this.conn.createStatement(); {
            stmt.executeUpdate(this.SQLQuery);
            System.out.println("Query executed successfully.");}
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

    public ResultSet retrieve() {
        ResultSet res = null;
        try {
            Statement stmt = this.conn.createStatement();
            res = stmt.executeQuery(this.SQLQuery);
            System.out.println("Query executed successfully.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Error: Integrity constraint violation - " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Error: Timeout occurred - " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Non-SQL Error: " + e.getMessage());
        }
        return res;
    }

}
