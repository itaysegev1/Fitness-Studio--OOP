package gym.customers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {

    private String name;
    private int money;
    Gender gender;
    private Date birthDate;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public Person(String name, int money, Gender gender, String birth) {
        this.name = name;
        this.money = money;
        this.gender = gender;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            System.out.println("Invalid date format for birthDate: " + birth);
            this.birthDate = null; // or assign a default value
        }
    }
    public Person(Person person) {
        this.name = person.name;
        this.money = person.money;
        this.gender = person.gender;
        this.birthDate = person.birthDate;
    }
    public String getName() {
        return name;
    }
    public int getMoney() {
        return money;
    }
    public Gender getGender() {
        return gender;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public int age(){
        LocalDate birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nowLocalDate = LocalDate.now();
        return Period.between(birthLocalDate, nowLocalDate).getYears();
    }
    public void setBalance(int balance) {
        money -= balance;
    }


}
