package gym.customers;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Person {

    private String name;
    private int money;
    Gender gender;
    LocalDateTime birth;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public Person(String name, int money, Gender gender, String birth) {
        this.name = name;
        this.money = money;
        this.gender = gender;
        this.birth =LocalDateTime.parse(birth, formatter);
    }
    public Person(Person person) {
        this.name = person.name;
        this.money = person.money;
        this.gender = person.gender;
        this.birth = person.birth;
    }
    private LocalDate parseDate(String date) {
        DateTimeFormatter newd = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            return LocalDate.parse(date, newd);
        }
        catch (DateTimeParseException e) {
            System.err.println("Invalid date format. Please use dd-MM-yyyy.");
        }
        return null;

    }

}
