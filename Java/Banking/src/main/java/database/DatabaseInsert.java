package database;

import account.Account;
import account.IndividualAccount;
import account.ParentalAccount;
import people.Person;
import people.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import utility.SimpleDate;

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

    public static void insertNewAccount(Account a, String userId) {
        System.out.println(a.getClass().getName());
        String className = a.getClass().getName();
        String accountType;
        if (className.equals("account.IndividualAccount")) {
            accountType = "individual_account";
        }
        else if (className.equals("account.ParentalAccount")) {
            accountType = "parental_account";
        }
        else {
            accountType = "joint_account";
        }
        String sqlQuery = String.format(
                        "insert into accounts " +
                        "(account_id, holder_id, account_type, balance, active, created_at, deleted_at)" +
                        "values ('%s', '%s', '%s', %f, %d, '%s', %s)",
                a.getAccountNumber(), userId, accountType, a.getBalance(), 1, SimpleDate.today(), null);
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        dbop.execute();
    }
    public static void insertNewIndividualAccount(IndividualAccount a) {
        insertNewAccount(a, a.getHolder().getId());
        String sqlQuery = String.format(
                        "insert into individual_accounts " +
                        "(account_id, holder_id, balance, holder_first_name, holder_last_name, created_at)" +
                        "values ('%s', '%s', %f, '%s', '%s', '%s')",
                a.getAccountNumber(), a.getHolder().getId(), a.getBalance(), a.getHolder().getFirstName(), a.getHolder().getLastName(), SimpleDate.today());
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        dbop.execute();
    }

    public static void insertNewParentalAccount(ParentalAccount a) {
        insertNewAccount(a, a.getHolder().getId());
        String sqlQuery = String.format(
                "insert into parental_accounts " +
                        "(account_id, guardian_id, dependent_id, balance, guardian_first_name, guardian_last_name, dependent_first_name, dependent_last_name, is_minor, created_at)" +
                        "values ('%s', '%s', '%s', %f, '%s', '%s', '%s', '%s', %d, '%s')",
                a.getAccountNumber(), a.getGuardian().getId(), a.getHolder().getId(), a.getBalance(),a.getGuardian().getFirstName(), a.getGuardian().getLastName(), a.getHolder().getFirstName(), a.getHolder().getLastName(), a.getHolder().isMinor() ? 1 : 0 , SimpleDate.today());
        DatabaseOperation dbop = new DatabaseOperation(sqlQuery);
        dbop.execute();
    }
}
