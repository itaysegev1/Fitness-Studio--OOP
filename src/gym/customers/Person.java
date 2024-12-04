package gym.customers;

public class Person {

    private String name;
    private int money;
    Gender gender;
    String birth;
    public Person(String name, int money, Gender gender, String birth) {
        this.name = name;
        this.money = money;
        this.gender = gender;
        this.birth = birth;
    }
    public Person(Person person) {
        this.name = person.name;
        this.money = person.money;
        this.gender = person.gender;
        this.birth = person.birth;
    }

}
