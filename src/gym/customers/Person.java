package gym.customers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {
    private int Id;
    private String Name;
    private Integer Balance;
    protected Gender Gender;
    private Date BirthDate;
    private static int ID=1111;
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * A regular constructor for a Person
     * @param name the name of the person
     * @param money the balance the person have
     * @param gender the gender of the person
     * @param birth  a string of the person BD need to be in this format-"dd-MM-yyyy"
     */
    public Person(String name, int money, Gender gender, String birth) {
        Id =ID;
        this.Name = name;
        this.Balance = money;
        this.Gender = gender;
        ID++;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.BirthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            System.out.println("Invalid date format for birthDate: " + birth);
            this.BirthDate = null; // or assign a default value
        }
    }

    /**
     * Copy Constructor
     * @param person the person we want to get a deep copy of it.
     */
    public Person(Person person) {
        this.Id =person.Id;
        this.Name = person.Name;
        this.Balance = person.Balance;
        this.Gender = person.Gender;
        this.BirthDate = person.BirthDate;
    }

    /////////////// Getters /////////////////
    public String getName() {
        return Name;
    }
    public int getBalance() {
        return Balance;
    }
    public Gender getGender() {
        return Gender;
    }
    public Date getBirthDate() {
        return BirthDate;
    }

    /**
     * This method compute this person age based on its B-Day and this current day
     * @return  An integer of the age.
     */
    public int age(){
        LocalDate birthLocalDate = BirthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nowLocalDate = LocalDate.now();
        return Period.between(birthLocalDate, nowLocalDate).getYears();
    }

    ///////////////// Setters //////////////////////
    public void setBalance(int balance) {
        Balance += balance;
    }

    /**
     * String that describe the peron: "ID: | Name: | Gender: | Birthday: | Age: | Balance: "
     * @return Person describe string
     */
    public String toString() {
        String bd= DATE_FORMAT.format(BirthDate);
        return ("ID: "+this.Id +" | Name: "+this.Name +" | Gender: "+this.Gender +" | Birthday: "+bd+" | Age: "
                +this.age()+" | Balance: "+this.Balance);
    }


}
