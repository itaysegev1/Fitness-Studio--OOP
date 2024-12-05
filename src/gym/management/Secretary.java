package gym.management;

import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.Instructor;

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
    public Client registerClient(Person person) {
        gym.addClient(new Client(person));
        return null;
        //////////// fill in /////////////
    }
    public void unregisterClient(Client client) {
        //////////// fill in /////////////
    }
    public void hireInstructor(Instructor instructor) {
        //////////// fill in /////////////
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
