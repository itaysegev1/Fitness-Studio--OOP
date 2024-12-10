package gym.management.Sessions;

import gym.customers.Gender;
import gym.customers.Person;

import java.util.Date;
import java.util.List;

public class Instructor {
    protected Person person;
    protected int salary;
    protected List<SessionType> sessionTypes;

    /**
     * Constructor of the Instructors
     * @param p the person
     * @param salary salary per hour
     * @param sessionTypes list of the session types he can coach
     */
    protected Instructor(Person p, int salary, List<SessionType> sessionTypes) {
        this.person = p;
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

    public String getName() {
        return person.getName();
    }

    public int getMoney() {
        return person.getBalance();
    }

    public Gender getGender() {
        return person.getGender();
    }

    public Date getBirthDate(){
        return person.getBirthDate();
    }


    /////////////// SETTERS //////////////////////
    public void setBalance(int money) {
        person.setBalance(money);
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

    protected void setSessionTypes(List<SessionType> sessionTypes) {
        this.sessionTypes = sessionTypes;
    }

    ///////////////// Methods //////////////////////

    /**
     * This method checks if this instructor and other instructor are the same
     * @param I1 the other instructor
     * @return if they are the same or not
     */
    protected boolean equals(Instructor I1){
        return (I1.getBirthDate().equals(this.person.getBirthDate()) && I1.getMoney() == this.person.getBalance()
                && I1.getName().equals(this.person.getName()) && I1.getGender() == this.person.getGender() &&
                this.salary == I1.getSalary() && this.sessionTypes.equals(I1.getSessionTypes()));
    }

    /**
     * A description of our instance
     * @return  "ID: | Name: | Gender: | Birthday: | Age: | Balance: | Role: | Salary per Hour: | Certified Classes: "
     */
    public String toString(){
        String s = this.person.toString();
        String ans="";
        for (int i=0; i<this.sessionTypes.size(); i++){
            if(i<this.sessionTypes.size()-1)
                ans+=sessionTypes.get(i).toString()+", ";
            else{
                ans+=sessionTypes.get(i).toString();
            }
        }

        s+=" | Role: Instructor | Salary per Hour: "+this.salary+" | Certified Classes: "+ans;
        return s+"\n";
    }
}
