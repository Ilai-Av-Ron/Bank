package people;

import lombok.Getter;
import utility.SimpleDate;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
public class User extends Person {
    private String email;
    private String password;

    public User(String id, String firstName, String lastName, double monthlyIncome, SimpleDate birthDate, String address, boolean married, String email, String password) {
        super(id, firstName, lastName, monthlyIncome, birthDate, address, married);
        assert validateEmail(email) : "Not a valid email format";
        assert validatePassword(password) : "Password must contain only English letters, digits, and symbols. Must be at least 8 characters long.";
        this.email = email;
        this.password = password;
    }

    public User(String id, SimpleDate birthDate, String email, String password) {
        this(id, "", "", 0., birthDate, "", false, email, password);
    }

    public User(ResultSet res) throws SQLException {
        this(
                res.getString("id_number"),
                res.getString("first_name"),
                res.getString("last_name"),
                res.getDouble("monthly_income"),
                new SimpleDate(res.getDate("birth_date").getYear() + 1900, res.getDate("birth_date").getMonth() + 1, res.getDate("birth_date").getDate()),
                res.getString("address"),
                res.getBoolean("married"),
                res.getString("email"),
                "88888888"
        );
    }

    private boolean validateEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return email.matches(emailPattern);
    }

    private boolean validatePassword(String password) {
        String passwordPattern = "^[a-zA-Z0-9@#$%&*!]*$";
        return password.length() >= 8 && password.matches(passwordPattern);
    }

    public void setEmail(String password, String previousEmail, String newEmail) {
        assert this.email.equals(previousEmail) && this.password.equals(password) : "Wrong credentials.";
        assert validateEmail(newEmail) : "Not a valid email format";
        this.email = newEmail;
    }

    public void setPassword(String previousPassword, String newPassword, String email){
        assert this.password.equals(previousPassword) && this.email.equals(email) : "Wrong credentials.";
        assert validatePassword(newPassword) : "Password must contain only English letters, digits, and symbols. Must be at least 8 characters long.";
        this.password = newPassword;
    }

}
