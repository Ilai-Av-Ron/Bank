package database;

import people.Person;
import people.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.sql.*;

public class DatabaseInsert {

    public static void insertNewPerson(Person p) {
        String sqlQuery = String.format(
                          "insert into people " +
                          "(id_number, first_name, last_name, birth_date, address, married, monthly_income)" +
                          "values ('%s', '%s', '%s', '%s', '%s', %d, %f)",
                          p.getId(), p.getFirstName(), p.getLastName(), p.getBirthDate().toString(), p.getAddress(), p.isMarried() ? 1 : 0, p.getMonthlyIncome());
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        dbop.execute();
    }

    public static void insertNewUser(User u) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(u.getPassword());
        String sqlQuery = String.format(
                "insert into users " +
                        "(id_number, active, first_name, last_name, birth_date, email, password)" +
                        "values ('%s', %d, '%s', '%s', '%s', '%s', '%s')",
                u.getId(), 1 , u.getFirstName(), u.getLastName(), u.getBirthDate().toString(), u.getEmail(), hashedPassword);
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        dbop.execute();
    }
}
