package database;

import people.Person;

import java.sql.*;

public class DatabaseInsert {

    public static void insertNewPerson(Person p) {
        String sqlQuery = String.format(
                          "insert into people " +
                          "(id_number, first_name, last_name, birth_date, address, married, monthly_income)" +
                          "values ('%s', '%s', '%s', '%s', '%s', %d, %f)",
                          p.getId(), p.getFirstName(), p.getLastName(), p.getBirthDate().toString(), p.getAddress(), p.isMarried(), p.getMonthlyIncome());
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        dbop.execute();
    }
}
