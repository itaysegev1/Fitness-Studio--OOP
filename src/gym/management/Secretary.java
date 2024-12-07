package gym.management;

import gym.Actions;
import gym.Exception.*;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Secretary extends Person {
    private static Secretary secretary;
    Gym gym;
    int salary;
    private List <String> actions;
    private boolean valid;

    private Secretary(Person person,int salary) {
        super(person);
        this.salary = salary;
        valid = true;
        gym=Gym.getInstance();
    }
    public static Secretary getInstance() {
        return secretary;
    }
    protected static void setSecretary(Person p1,int salary) {
        if (secretary != null) {
            secretary.fire_secretary();
        }
        secretary=new Secretary(p1,salary);
    }
    public Client registerClient(Person person)
            throws InvalidAgeException, DuplicateClientException, InstructorNotQualifiedException, ClientNotRegisteredException {
        check_valid();
        List<Object> list=new ArrayList<>();
        list.add(Actions.registerClient);
        list.add(person);
        return (Client) FactoryOfActions.createActions(list);
    }
    public void unregisterClient(Client client)
            throws ClientNotRegisteredException, InvalidAgeException, InstructorNotQualifiedException, DuplicateClientException {
        check_valid();
        List<Object> list=new ArrayList<>();
        list.add(Actions.unregisterClient);
        list.add(client);
        FactoryOfActions.createActions(list);
        //////////// fill in /////////////
    }
    public Instructor hireInstructor(Person p1, int salary, List<SessionType> sessionstype)
            throws InvalidAgeException, InstructorNotQualifiedException, DuplicateClientException, ClientNotRegisteredException {
        check_valid();
        List<Object> list=new ArrayList<>();
        list.add(Actions.hireInstructor);
        list.add(p1);
        list.add(salary);
        list.add(sessionstype);
        return (Instructor) FactoryOfActions.createActions(list);
    }
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor)
            throws InstructorNotQualifiedException, InvalidAgeException, DuplicateClientException, ClientNotRegisteredException {
        check_valid();
        List<Object> list=new ArrayList<>();
        list.add(Actions.addSession);
        list.add(sessionType);
        list.add(date);
        list.add(forumType);
        list.add(instructor);
        return (Session) FactoryOfActions.createActions(list);
    }

    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException, ClientNotRegisteredException, InvalidAgeException, InstructorNotQualifiedException {
        check_valid();
        List<Object> list=new ArrayList<>();
        list.add(Actions.registerClientToSession);
        list.add(session);
        list.add(client);
        FactoryOfActions.createActions(list);
    }
    public void notify(String message) {}
    public void notify(String date, String message) {}
    public void notify(Session session, String message) {}
    public void paySalaries(){
        check_valid();
    }

    public void printActions() {
        check_valid();
        List<String>actions=gym.getHistory();
        for (String action:actions) {
            System.out.println(action);
        }
        System.out.println();
    }

    protected void check_valid() throws NullPointerException{
        if(!valid)
            throw new NullPointerException();
    }
    protected void fire_secretary(){
        gym=null;
        salary=0;
        actions=null;
        secretary=null;
        valid=false;
    }
}
