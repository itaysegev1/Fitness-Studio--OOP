package gym.management;

import gym.customers.Client;
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
    private RealSecretary secretary;
    private SecretaryProxy secretaryProxy;
    private int balance;
    private String name;
    private List<Client> clients;
    private List<Instructor> instructors;
    private List<Session> sessions;

    /**
     * this is a private constructor of the gym cause there is only one gym.
     */
    private Gym() {
        balance = 0;
        clients = new ArrayList<>();
        instructors = new ArrayList<>();
        sessions = new ArrayList<>();
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

    protected List<Session> getSessions() {
        return sessions;
    }

    protected int getBalance() {
        return balance;
    }

    public Secretary getSecretary() {
        return secretaryProxy;
    }

    //////////////// Setters //////////////////
    /**
     * this method is for clients that pay for sessions
     *
     * @param balance how much did they pay
     */
    protected void payforclass(int balance) {
        this.balance += balance;
    }

    /**
     * This method is for taking off the salary of the Employs from gym balance
     *
     * @param balance how much they needed to get paid
     */
    protected void paySalary(int balance) {
        this.balance -= balance;
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
        if(secretaryProxy == null) {
            secretary = new RealSecretary(p1, salary);
            secretaryProxy = new SecretaryProxy(secretary);
        }
        else {
            secretaryProxy.block();
            secretary = new RealSecretary(p1, salary);
            secretaryProxy = new SecretaryProxy(secretary);
        }
        GymLogger.getInstance().log("A new secretary has started working at the gym: " + p1.getName());
    }

    /**
     * This method add to the list of the clients new client
     *
     * @param client the client that needed to be added
     */
    protected void addClient(Client client) {
        clients.add(client);
        this.attach(client);
    }

    /**
     * This method remove a client that need to be removed from the gym and removed him also from the notifier.
     *
     * @param client the client that need to be remove.
     */
    protected void RemoveClient(Client client) {
        Client c = null;
        for (Client c1 : clients) {
            if (c1.equals(client)) {
                c = c1;
            }
        }
        if (c != null) {
            clients.remove(c);
            this.detach(c);
        }

    }

    /**
     * This method added the instructor to the gym instructors
     *
     * @param instructor the instructor that needed to be added
     */
    protected void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    /**
     * This method remove the instructor from the gym.
     *
     * @param instructor the instructor needed to be removed
     * @return if he removed
     */
    protected boolean removeInstructor(Instructor instructor) {
        for (Instructor i : instructors) {
            if (i.equals(instructor)) {
                instructors.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * This method add new session to the gym
     *
     * @param session the session need to be added
     * @return if it had been added or not
     */
    protected boolean addSession(Session session) {
        if (!IsContainSession(session)) {
            sessions.add(session);
            return true;
        }
        return false;
    }

    /**
     * This method remove this session from the sessions of the gym
     *
     * @param session the session needed to be removed
     * @return if it had been removed
     */
    protected boolean removeSession(Session session) {
        for (Session session2 : sessions) {
            if (session2.equals(session)) {
                sessions.remove(session2);
                return true;
            }
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
        for (Client c2 : clients) {
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
        for (Instructor i2 : instructors) {
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
        for (Session s2 : sessions) {
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
        s += "Gym Secretary: " + secretary;
        s += "Gym Balance: " + balance + "\n";
        s += "\nClients Data:\n";
        for (Client c : clients) {
            s += c.toString();
        }
        s += "\nEmployees Data:\n";
        for (Instructor i : instructors) {
            s += i.toString();
        }
        s += secretary.toString();
        s += "\nSessions Data:\n";
        for (Session session : sessions) {
            s += session.toString();
        }
        return s;
    }
}
