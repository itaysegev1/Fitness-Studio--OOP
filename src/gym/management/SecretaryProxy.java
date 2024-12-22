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

public class SecretaryProxy implements Secretary {
    private RealSecretary realSecretary;
    private String secretarydescription;

    public SecretaryProxy(RealSecretary realSecretary) {
        this.realSecretary = realSecretary;
        this.secretarydescription=realSecretary.toString();
    }

    public void block() {
        realSecretary=null;
    }

    @Override
    public int get_paid() {
        return realSecretary.get_paid();
    }

    @Override
    public int get_monthly_payment() {
        return realSecretary.get_monthly_payment();
    }

    @Override
    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException {
        return realSecretary.registerClient(person);
    }

    @Override
    public void unregisterClient(Client client) throws ClientNotRegisteredException {
        realSecretary.unregisterClient(client);
    }

    @Override
    public Instructor hireInstructor(Person p1, int salary, List<SessionType> sessionstype) {
        return realSecretary.hireInstructor(p1, salary, sessionstype);
    }

    @Override
    public void fireInstructor(Instructor instructor) {
        realSecretary.fireInstructor(instructor);
    }

    @Override
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor)
            throws InstructorNotQualifiedException {
        return realSecretary.addSession(sessionType, date, forumType, instructor);
    }

    @Override
    public void deleteSession(Session session) {
        realSecretary.deleteSession(session);
    }

    @Override
    public void registerClientToLesson(Client client, Session session)
            throws DuplicateClientException, ClientNotRegisteredException {
        realSecretary.registerClientToLesson(client, session);
    }

    @Override
    public void notify(String message) {
        realSecretary.notify(message);
    }

    @Override
    public void notify(String date, String message) {
        realSecretary.notify(date, message);
    }

    @Override
    public void notify(Session session, String message) {
        realSecretary.notify(session, message);
    }

    @Override
    public void paySalaries() {
        realSecretary.paySalaries();
    }

    @Override
    public void printActions() {
        realSecretary.printActions();
    }
    public String toString() {
        return this.secretarydescription;
    }
}

