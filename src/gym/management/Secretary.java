package gym.management;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

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
    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException {
        Client client = new Client(person);
        if(client.age()<18)
            throw new InvalidAgeException();
        if(!gym.addClient(client))
            throw new DuplicateClientException();
        return client;
        //////////// fill in /////////////
    }
    public void unregisterClient(Client client) throws ClientNotRegisteredException{
        gym.removeClient(client);
        //////////// fill in /////////////
    }
    public Instructor hireInstructor(Person p1, int salary, List<SessionType> sessionstype) {
        //////////// fill in /////////////
        return null;
    }
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor)
            throws InstructorNotQualifiedException
    {
        if(instructor.getSessionTypes().contains(sessionType))
            throw new InstructorNotQualifiedException();
        Session session=new Session(sessionType,date,forumType,instructor);
        gym.addSession(new Session(sessionType,date,forumType,instructor));
        return session;
    }
    public void registerClientToLesson(Client client, Session session)
            throws DuplicateClientException, ClientNotRegisteredException{
        ////////// fill in ////////////////

    }
    public void notify(String message) {}
    public void notify(String date, String message) {}
    public void notify(Session session, String message) {}
    public void paySalaries(){}

    public void printActions() {
        List<String>actions=gym.getHistory();
        System.out.println("---Actions history---");
        for (String action:actions) {
            System.out.println(action);
        }
        System.out.println();
    }
}
