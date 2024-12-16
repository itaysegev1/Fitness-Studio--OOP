package gym.management.Sessions;

import gym.customers.Gender;
import gym.customers.Person;

import java.util.Date;
import java.util.List;

public class Instructor extends Person {
    protected int salary;
    protected List<SessionType> sessionTypes;

    /**
     * Constructor of the Instructors
     * @param p the person
     * @param salary salary per hour
     * @param sessionTypes list of the session types he can coach
     */
    protected Instructor(Person p, int salary, List<SessionType> sessionTypes) {
        super(p);
        this.salary = salary;
        this.sessionTypes = sessionTypes;
    }

    ////////////////// GETTERS ////////////////////
    public int getSalary() {
        return salary;
    }

    public List<SessionType> getSessionTypes() {
        return sessionTypes;
    }



    /////////////// SETTERS //////////////////////
    public void pay_for_class(int money) {
        this.Balance.addMoney(money);
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

    protected void setSessionTypes(List<SessionType> sessionTypes) {
        this.sessionTypes = sessionTypes;
    }

    ///////////////// Methods //////////////////////

    /**
     * A description of our instance
     * @return  "ID: | Name: | Gender: | Birthday: | Age: | Balance: | Role: | Salary per Hour: | Certified Classes: "
     */
    public String toString(){
        String s = super.toString();
        String ans="";
        for (int i=0; i<this.sessionTypes.size(); i++){
            if(i<this.sessionTypes.size()-1)
                ans+=sessionTypes.get(i).toString()+", ";
            else{
                ans+=sessionTypes.get(i).toString();
            }
        }

        s+=" | Role: Instructor | Salary per Hour: "+this.salary+" | Certified Classes: "+ans;
        return s;
    }
}
