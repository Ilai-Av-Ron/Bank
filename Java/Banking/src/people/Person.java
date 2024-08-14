package src.people;

import java.util.Random;
import lombok.*;
import src.utility.SimpleDate;


@Data
public class Person {
    private final String id;
    private String firstName;
    private String lastName;
    private double monthlyIncome;
    private final SimpleDate birthDate;

    public Person(String id, String firstName, String lastName, double monthlyIncome, SimpleDate birthDate) {
        assert monthlyIncome >= 0 : "Monthly income can't be a negative value.";
        assert birthDate.before(SimpleDate.today()) : "Birth date must be earlier than today.";
        assert validateId(id) : "Id must be unique, and should be comprised of nine digits.";
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlyIncome = monthlyIncome;
        this.birthDate = birthDate;
    }

    public Person(String id, SimpleDate birthDate){
        this(id, "", "", 0., birthDate);
    }

    public Boolean validateId(String id){
        if (true){
            return true;
        }
        return false;
    }

    public String generateId(){
        String digits = "0123456789";
        StringBuilder id = new StringBuilder();
        Random random = new Random();
        while (id.length() < 9){
            int index = (int) (random.nextFloat() * digits.length());
            id.append(digits.charAt(index));
        }
        return id.toString();
    }

    public boolean isMinor(){
        return new SimpleDate(this.birthDate.getYear() + 18, this.birthDate.getMonth(), this.birthDate.getDay()).before(SimpleDate.today());
    }
}


