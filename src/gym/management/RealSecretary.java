package gym.management;

import gym.Exception.*;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RealSecretary extends Person implements Secretary {
    private Gym gym;
    private int salary;
    private GymLogger logger;
    private GymData data;

    protected RealSecretary(Person person, int salary) {
        super(person);
        this.salary = salary;
        gym = Gym.getInstance();
        logger = GymLogger.getInstance();
        data=GymData.getInstance();
    }

    protected void firesecretary() {
        gym = null;
        logger = null;
        salary = 0;
        data=null;
    }

    @Override
    public int get_paid() {
        this.Balance.addMoney(salary);
        return salary;
    }

    @Override
    public int get_monthly_payment() {
        this.Balance.addMoney(salary);
        return salary;
    }

    @Override
    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException {
        return RegisterClient.Do(person);
    }

    @Override
    public void unregisterClient(Client client) throws ClientNotRegisteredException {
        UnregisteredClient.Do(client);
    }

    @Override
    public Instructor hireInstructor(Person p1, int salary, List<SessionType> sessionstype) {
        return HireInstructor.Do(p1, salary, sessionstype);
    }


    @Override
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {
        return AddSession.Do(sessionType, date, forumType, instructor);
    }


    @Override
    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException, ClientNotRegisteredException {
        RegisterClientToSession.Do(session, client);
    }

    @Override
    public void notify(String message) {
        String msg = ("A message was sent to all gym clients: " + message);
        logger.log(msg);
        gym.notify(message);
    }

    @Override
    public void notify(String date, String message) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate newdate = LocalDate.parse(date, dateFormatter);
        String msg = ("A message was sent to everyone registered for a session on " + newdate + " : " + message);
        logger.log(msg);
        for (Session session : data.getSessionList()) {
            if (session.getDate().toLocalDate().equals(newdate)) {
                session.notify(message);
            }
        }
    }

    @Override
    public void notify(Session session, String message) {
        if (data.getSessionList().contains(session)) {
            String msg = ("A message was sent to everyone registered for session " + session.getClass().getSimpleName() + " on "
                    + session.getDate() + " : " + message);
            logger.log(msg);
            session.notify(message);
        }

    }

    @Override
    public void paySalaries() {
        PaySalaries.Do(data.getEmployList());
        logger.log("Salaries have been paid to all employees");
    }

    @Override
    public void printActions() {
        logger.printLog();
    }

    public String toString() {
        return super.toString() + " | Role: Secretary | Salary per Month: " + salary;
    }
}
