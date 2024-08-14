package src.people;

import lombok.Getter;
import src.utility.SimpleDate;

@Getter
public class User extends Person{
    private String email;
    private String password;

    public User(String id, String firstName, String lastName, double monthlyIncome, SimpleDate birthDate, String email, String password) {
        super(id, firstName, lastName, monthlyIncome, birthDate);
        assert validateEmail(email) : "Not a valid email format";
        assert validatePassword(password) : "Password must contain only English letters, digits, and symbols. Must be at least 8 characters long.";
        this.email = email;
        this.password = password;
    }

    public User(String id, SimpleDate birthDate, String email, String password){
        this(id, "", "", 0., birthDate, email, password);
    }

    private boolean validateEmail(String email){
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return email.matches(emailPattern);
    }

    private boolean validatePassword(String password){
        String passwordPattern = "^[a-zA-Z0-9@#$%&*!]*$";
        return password.length() >= 8 && password.matches(passwordPattern);
    }

    public void setEmail(String password, String previousEmail, String newEmail){
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
