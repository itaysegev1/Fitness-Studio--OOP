package gym.management.Sessions;

import gym.customers.Gender;
import gym.customers.Person;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    protected double salary;
    protected List<SessionType>l;

    public Instructor(String name, int money, Gender gender, String birth,double salary) {
        super(name, money, gender, birth);
        this.l = new ArrayList<SessionType>();
        this.salary = salary;
    }


    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    private boolean cancoach(){
        return true;
    }
}
