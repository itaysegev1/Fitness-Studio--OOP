package gym.management;

import gym.Exception.*;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
            throws InvalidAgeException, DuplicateClientException{
        check_valid();
        return RegisterClient.Do(person);
    }
    public void unregisterClient(Client client)
            throws ClientNotRegisteredException {
        check_valid();
        UnregisteredClient.Do(client);
    }
    public Instructor hireInstructor(Person p1, int salary, List<SessionType> sessionstype) {
        check_valid();
        return HireInstructor.Do(p1, salary, sessionstype);
    }
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor)
            throws InstructorNotQualifiedException {
        check_valid();
        return AddSession.Do(sessionType, date, forumType, instructor);
    }

    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException, ClientNotRegisteredException, InvalidAgeException, InstructorNotQualifiedException {
        check_valid();
        RegisterClientToSession.Do(session,client);
    }
    public void notify(String message) {
        check_valid();
        String msg=("A message was sent to all gym clients: "+message);
        logger.log(msg);
        gym.notify(message);
    }
    public void notify(String date, String message) {
        check_valid();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate newdate = LocalDate.parse(date, dateFormatter);
        String msg=("A message was sent to everyone registered for a session on "+newdate+" : "+message);
        logger.log(msg);
        for (Session session : gym.getSessions()) {
            if (session.getDate().toLocalDate().equals(newdate)) {
                session.notify(message);
            }
        }
    }
    public void notify(Session session, String message) {
        check_valid();
        String msg=("A message was sent to everyone registered for session "+session.getClass().getSimpleName()+" on "
                +session.getDate()+" : "+message);
        logger.log(msg);
        session.notify(message);
    }
    public void paySalaries() throws InvalidAgeException, InstructorNotQualifiedException, DuplicateClientException, ClientNotRegisteredException {
        check_valid();
        PaySalaries.Do();
        logger.log("Salaries have been paid to all employees");
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
