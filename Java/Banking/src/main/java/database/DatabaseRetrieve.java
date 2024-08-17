package database;

import account.Account;
import account.IndividualAccount;
import account.JointAccount;
import account.ParentalAccount;
import people.Person;
import people.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import utility.SimpleDate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRetrieve {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public static User retrieveUserEmail(String email, String password) {
        String sqlQuery = String.format(
                "select users.id_number, users.first_name, users.last_name, people.birth_date, people.address, people.married, people.monthly_income, users.email, users.password " +
                "from users left join people on users.id_number = people.id_number " +
                "where email = '%s'", email);
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        ResultSet res = dbop.retrieve();
        try {
            if (res.next()) {
                String storedHash = res.getString("password");
                if (passwordEncoder.matches(password, storedHash)) {
                    return new User(res);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void retrieveUserId(String id, String password) {
        String sqlQuery = String.format(
                "select * from users " +
                        "where email = '%s' and password = '%s'", id, password);
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        ResultSet res = dbop.retrieve();
    }
}
