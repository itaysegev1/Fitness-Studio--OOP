package gym.management.Sessions;

import gym.customers.Gender;
import gym.customers.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Instructor {
    protected Person person;
    protected int salary;
    protected List<SessionType> sessionTypes;

    public Instructor(Person p, int salary, List<SessionType> sessionTypes) {
        this.person = p;
        this.salary = salary;
        this.sessionTypes = sessionTypes;
    }
    /// /////// GETTERS///////////////
    public int getSalary() {
        return salary;
    }

    public List<SessionType> getSessionTypes() {
        return sessionTypes;
    }

    public String getName() {
        return person.getName();
    }
    public int getMoney() {
        return person.getMoney();
    }
    public Gender getGender() {
        return person.getGender();
    }
    public Date getBirthDate(){
        return person.getBirthDate();
    }
    /// /////SETTERS//////////////////////
    public void setSalary(int salary) {
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
        return (I1.getBirthDate().equals(this.person.getBirthDate()) && I1.getMoney() == this.person.getMoney()
                && I1.getName().equals(this.person.getName()) && I1.getGender() == this.person.getGender() &&
                this.salary == I1.getSalary() && this.sessionTypes.equals(I1.getSessionTypes()));
    }
    public String toString(){
        String s = this.person.toString();
        s+=" | Role: Instructor | Salary per Hour: "+this.salary+" | Certified Classes: "+this.sessionTypes;
        return s+"\n";
    }
}
