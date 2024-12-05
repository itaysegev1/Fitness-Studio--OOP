package gym.management;

import gym.customers.Person;

import java.util.List;

public class Secretary extends Person {
    private static Secretary secretary;
    Gym gym;
    int salary;
    private List <String> actions;

    private Secretary(Person person,int salary) {
        super(person);
        this.salary = salary;
        gym=Gym.getInstance();
    }
    public static Secretary getInstance() {
        return secretary;
    }
    protected static void setSecretary(Person p1,int salary) {
        secretary=new Secretary(p1,salary);
    }
    public void printActions() {
        List<String>actions=gym.getHistory();
        System.out.println("---Actions history---");
        for (String action:actions) {
            System.out.println(action);
        }
        System.out.println();
    }
}
