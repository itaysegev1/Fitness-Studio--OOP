package gym.management.Sessions;

import gym.customers.Gender;
import gym.customers.Person;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    protected double salary;
    protected List<SessionType>l;


    public Instructor(String name, int money, Gender gender, String birth) {
        super(name, money, gender, birth);
        l = new ArrayList<SessionType>();
    }
    /// /////// GETTERS///////////////
    public double getSalary() {
        return salary;
    }
    public List<SessionType> getL() {
        return l;
    }
    /// /////SETTERS//////////////////////
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setL(List<SessionType> l) {
        this.l = l;
    }
    private boolean cancoach(SessionType s){
        if(l.contains(s)){
            return true;
        }
        return false;
    }
}
