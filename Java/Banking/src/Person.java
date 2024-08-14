package src;

import java.util.Random;
import lombok.*;


@Data
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Double monthlyIncome;
    private SimpleDate birthDate;
    private Boolean isMinor;

    public Person(String id, String firstName, String lastName, Double monthlyIncome, SimpleDate birthDate) {
        assert monthlyIncome >= 0 : "Monthly income can't be a negative value.";
        assert birthDate.before(SimpleDate.today()) : "Birth date must be earlier than today.";
        assert validateId(id) : "Id must be unique, and should be comprised of nine digits.";
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlyIncome = monthlyIncome;
        this.birthDate = birthDate;
        this.isMinor = new SimpleDate(birthDate.getYear() + 18, birthDate.getMonth(), birthDate.getDay()).before(SimpleDate.today());
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
}


