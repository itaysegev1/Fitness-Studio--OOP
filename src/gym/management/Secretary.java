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

public class Secretary{
    private static Secretary secretary;
    private Person person;
    private Gym gym;
    private int salary;
    private List <String> actions;
    private boolean valid;
    private GymLogger logger;

    private Secretary(Person person,int salary) {
        this.person = person;
        this.salary = salary;
        valid = true;
        gym=Gym.getInstance();
        logger=GymLogger.getInstance();
    }
    protected int get_monthly_payment(){
        person.setBalance(salary);
        return salary;
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
    public void notify(String message) {
        check_valid();
    }
    public void notify(String date, String message) {
        check_valid();
    }
    public void notify(Session session, String message) {
        check_valid();
    }
    public void paySalaries() throws InvalidAgeException, InstructorNotQualifiedException, DuplicateClientException, ClientNotRegisteredException {
        check_valid();
        List<Object> list=new ArrayList<>();
        list.add(Actions.paySalaries);
        FactoryOfActions.createActions(list);
    }

    public void printActions() {
        check_valid();
        logger.printLog();
    }

    protected void check_valid() throws NullPointerException{
        if(!valid)
            throw new NullPointerException();
    }
    protected void fire_secretary(){
        this.person=null;
        gym=null;
        salary=0;
        actions=null;
        secretary=null;
        valid=false;
    }

    public String toString(){
        String s=this.person.toString();
        s+=" | Role: Secretary | Salary per Month: "+salary;
        return s+"\n";
    }
}
