package gym.management.Sessions;

import gym.customers.Person;
import gym.management.Employ;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person implements Employ {
    protected int salary;
    protected List<SessionType> sessionTypes;
    protected List<Session> sessions;

    /**
     * Constructor of the Instructors
     * @param p the person
     * @param salary salary per hour
     * @param sessionTypes list of the session types he can coach
     */
    protected Instructor(Person p, int salary, List<SessionType> sessionTypes) throws IllegalArgumentException{
        super(p);
        if(p.getBirthDate()==null)
            throw new IllegalArgumentException("Invalid birth date");
        this.salary = salary;
        this.sessionTypes = sessionTypes;
        sessions = new ArrayList<>();
    }

    ////////////////// GETTERS ////////////////////
    public int getSalary() {
        return salary;
    }

    public List<SessionType> getSessionTypes() {
        return sessionTypes;
    }



    /////////////// SETTERS //////////////////////
    @Override
    public int get_paid() {
        this.Balance.addMoney(this.salary*sessions.size());
        return this.salary*sessions.size();
    }
    public void addSession(Session s){
        this.sessions.add(s);
    }
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
