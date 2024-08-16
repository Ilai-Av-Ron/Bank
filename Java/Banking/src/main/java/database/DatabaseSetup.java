package database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
             String q0 = "create table if not exists people (" +
                         "id_number varchar(9) unique not null, " +
                         "active tinyint not null, " +
                         "first_name text, " +
                         "last_name text, " +
                         "birth_date date not null, " +
                         "email text, " +
                         "address text, " +
                         "married tinyint, " +
                         "monthly_income decimal(10, 2) check (monthly_income >= 0))";
             stmt.executeUpdate(q0);
             String q1 = "create table if not exists users (" +
                         "id_number varchar(9) unique not null, " +
                         "active tinyint not null, " +
                         "first_name text, " +
                         "last_name text, " +
                         "birth_date date not null, " +
                         "email text, " +
                         "password text not null)";
             stmt.executeUpdate(q1);
             String q2 = "create table if not exists accounts (" +
                         "account_id char(36) primary key, " +
                         "holder_id varchar(9) not null, " +
                         "account_type enum ('individual_account', 'joint_account', 'parental_account'), " +
                         "balance decimal(12, 2), " +
                         "active tinyint not null, " +
                         "created_at date default (current_date), " +
                         "deleted_at date)";
             stmt.executeUpdate(q2);
             String q3 = "create table if not exists individual_accounts (" +
                         "account_id char(36) primary key, " +
                         "holder_id varchar(9) not null, " +
                         "balance decimal(12, 2), " +
                         "holder_first_name text, " +
                         "holder_last_name text, " +
                         "created_at date default (current_date))";
             stmt.executeUpdate(q3);
             String q4 = "create table if not exists joint_accounts (" +
                         "account_id char(36) primary key, " +
                         "holder1_id varchar(9) not null, " +
                         "holder2_id varchar(9) not null, " +
                         "balance decimal(12, 2), " +
                         "holder1_first_name text, " +
                         "holder1_last_name text, " +
                         "holder2_first_name text, " +
                         "holder2_last_name text, " +
                         "created_at date default (current_date))";
             stmt.executeUpdate(q4);
             String q5 = "create table if not exists parental_accounts (" +
                         "account_id char(36) primary key, " +
                         "guardian_id varchar(9) not null, " +
                         "dependent_id varchar(9) not null, " +
                         "balance decimal(12, 2), " +
                         "guardian_first_name text, " +
                         "guardian_last_name text, " +
                         "dependent_first_name text, " +
                         "dependent_last_name text, " +
                         "is_minor tinyint)";
             stmt.executeUpdate(q5);
             String q6 = "create table if not exists loans (" +
                         "loan_id char(36) primary key, " +
                         "account_id char(36) not null, " +
                         "loaner_id varchar(9) not null, " +
                         "loan_date date default (current_date) not null, " +
                         "is_paid_back tinyint not null, " +
                         "loan_sum decimal(13, 2) not null check (loan_sum >= 0), " +
                         "interest_rate decimal (7,6) not null check (interest_rate between 0 and 1), " +
                         "monthly_payment decimal (10, 2) not null, " +
                         "number_of_months smallint not null check (number_of_months >= 1), " +
                         "principal decimal (13, 2) not null check (principal >= 0)," +
                         "last_payment_id char(36), " +
                         "last_payment_date date, " +
                         "last_payment_amount decimal check (last_payment_amount >= 0 or last_payment_amount is null), " +
                         "check (monthly_payment between 0 and loan_sum))";
             stmt.executeUpdate(q6);
             String q7 = "create table if not exists loan_payments (" +
                         "payment_id char(36) primary key, " +
                         "loan_id char(36) not null, " +
                         "account_id char(36) not null, " +
                         "payment_date date default (current_date) not null, " +
                         "payment_amount decimal (10, 2) not null check (payment_amount >= 0))";
             stmt.executeUpdate(q7);
             String q8 = "create table if not exists transactions (" +
                         "transaction_id char(36) primary key, " +
                         "account_id char(36) not null, " +
                         "transaction_date date default (current_date) not null, " +
                         "action enum ('withdrawal', 'deposit') not null, " +
                         "amount decimal (12, 2) check (amount >= 0))";
             stmt.executeUpdate(q8);
             String q9 = "create table if not exists transfers (" +
                         "transfer_id char(36) primary key, " +
                         "transfer_date date default (current_date) not null, " +
                         "payer_id varchar(9) not null, " +
                         "payer_account_id char(36) not null, " +
                         "recipient_id varchar(9) not null, " +
                         "recipient_account_id char(36) not null, " +
                         "transfer_amount decimal (10, 2) not null check (transfer_amount > 0))";
             stmt.executeUpdate(q9);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTables();
    }
}
