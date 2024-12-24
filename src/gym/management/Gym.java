package gym.management;

import gym.customers.Client;
import gym.Money_Account;
import gym.customers.Person;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton Class for the gym, cause there is only one gym that be managed in the main.
 */
public class Gym extends Subject {
    private static final Gym gym = new Gym();
    private GymData data=GymData.getInstance();
    private Secretary secretary;
    private String name;

    /**
     * this is a private constructor of the gym cause there is only one gym.
     */
    private Gym() {
        data.setBalance(0);
    }

    /////////////// Getters /////////////////
    /**
     * this method return the current instance of the gym.
     *
     * @return gym instance
     */
    public static Gym getInstance() {
        return gym;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    //////////////// Setters //////////////////
    /**
     * this method is for clients that pay for sessions
     *
     * @param balance how much did they pay
     */
    protected void payforclass(int balance) {
        data.setBalance(balance);
    }

    /**
     * This method is for taking off the salary of the Employs from gym balance
     *
     * @param balance how much they needed to get paid
     */
    protected void paySalary(int balance) {
        data.setBalance(-balance);
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method set the secretary of the gym, and fire the ex-secretary
     *
     * @param p1     the person that the secretary is
     * @param salary how much get paid for month
     */
    public void setSecretary(Person p1, int salary) {
        if (secretary == null) {
            secretary = new SecretaryProxy(new RealSecretary(p1, salary));
            data.addEmploy(secretary);
        } else {
            data.removeEmploy(secretary);
            ((SecretaryProxy) secretary).block();
            secretary = new SecretaryProxy(new RealSecretary(p1, salary));
            data.addEmploy(secretary);

        }
        GymLogger.getInstance().log("A new secretary has started working at the gym: " + p1.getName());
    }

    /**
     * This method add to the list of the clients new client
     *
     * @param client the client that needed to be added
     */
    protected void addClient(Client client) {
        data.addClient(client);
        this.attach(client);
    }

    /**
     * This method remove a client that need to be removed from the gym and removed him also from the notifier.
     *
     * @param client the client that need to be remove.
     */
    protected void RemoveClient(Client client) {
        Client c = null;
        for (Client c1 : data.getClientList()) {
            if (c1.equals(client)) {
                c = c1;
            }
        }
        if (c != null) {
            data.removeClient(c);
            this.detach(c);
        }

    }

    /**
     * This method added the instructor to the gym instructors
     *
     * @param instructor the instructor that needed to be added
     */
    protected void addInstructor(Instructor instructor) {
        data.addEmploy(instructor);
    }


    /**
     * This method add new session to the gym
     *
     * @param session the session need to be added
     * @return if it had been added or not
     */
    protected boolean addSession(Session session) {
        if (!IsContainSession(session)) {
            data.addSession(session);
            return true;
        }
        return false;
    }
    

    /**
     * This method check if there are client that it is the same in the gym
     *
     * @param c1 the client needed to be checked
     * @return if the gym contains it or not
     */
    protected boolean IsContainClient(Client c1) {
        for (Client c2 : data.getClientList()) {
            if (c2.equals(c1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method check if there are instructor that it is the same in the gym
     *
     * @param i1 the instructor needed to be checked
     * @return if the gym contains it or not
     */
    protected boolean IsContainInstructor(Instructor i1) {
        for (Employ i2 : data.getEmployList()) {
            if (i1.equals(i2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method check if there are session that it is the same in the gym
     *
     * @param s1 the session needed to be checked
     * @return if the gym contains it or not
     */
    protected boolean IsContainSession(Session s1) {
        for (Session s2 : data.getSessionList()) {
            if (s2.equals(s1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method charges on notify to all the clients of the gym a message
     *
     * @param message the message
     */
    protected void notify(String message) {
        this.notifyObservers(message);
    }

    /**
     * a String that describe the gym:
     * "Gym Name:
     * Gym Secretary:
     * Gym Balance:
     * Clients Data:
     * Employees Data:
     * Sessions Data:
     *
     * @return the string with all the details
     */
    public String toString() {
        String s = "Gym Name: " + name + "\n";
        s += "Gym Secretary: " + secretary + "\n";
        s+=data.toString();
        return s;
    }
}
