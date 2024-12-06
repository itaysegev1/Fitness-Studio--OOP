package gym.management.Sessions;

import gym.customers.Gender;
import gym.customers.Person;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    protected double salary;
    protected List<SessionType> sessionTypes;


    public Instructor(String name, int money, Gender gender, String birth) {
        super(name, money, gender, birth);
        sessionTypes = new ArrayList<SessionType>();
    }
    /// /////// GETTERS///////////////
    public double getSalary() {
        return salary;
    }

    public List<SessionType> getSessionTypes() {
        return sessionTypes;
    }

    /// /////SETTERS//////////////////////
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSessionTypes(List<SessionType> sessionTypes) {
        this.sessionTypes = sessionTypes;
    }

    private boolean cancoach(SessionType s){
        if(sessionTypes.contains(s)){
            return true;
        }
        return false;
    }

    public boolean equals(Instructor I1){
        return (I1.getBirthDate().equals(this.getBirthDate()) && I1.getMoney() == this.getMoney()
                && I1.getName().equals(this.getName()) && I1.getGender() == this.getGender() &&
                this.salary == I1.getSalary() && this.sessionTypes.equals(I1.getSessionTypes()));
    }
}
