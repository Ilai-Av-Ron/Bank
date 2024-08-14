import java.util.Date;
import java.util.Random;
import lombok.*;


@Data
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Double monthlyIncome;
    private Date birthDate;

    public Person(String id, String firstName, String lastName, Double monthlyIncome, Date birthDate) {
        assert monthlyIncome >= 0 : "Monthly income can't be a negative value.";
        assert birthDate.before(new Date()) : "Birth date can't must be earlier than today.";
        assert validateId(id) : "Id must be unique, and should be comprised of nine digits.";
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlyIncome = monthlyIncome;
        this.birthDate = birthDate;
    }

    public Person(String id, Date birthDate){
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


