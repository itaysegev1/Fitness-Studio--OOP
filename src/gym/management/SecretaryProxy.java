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
    private boolean isBlocked = false;

    public SecretaryProxy(RealSecretary realSecretary) {
        this.realSecretary = realSecretary;
    }

    public void block() {
        isBlocked = true;
    }

    private void checkValid() {
        if (isBlocked) {
            throw new NullPointerException("Error: Former secretaries are not permitted to perform actions");
        }
    }

    @Override
    public int get_monthly_payment() {
        checkValid();
        return realSecretary.get_monthly_payment();
    }

    @Override
    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException {
        checkValid();
        return realSecretary.registerClient(person);
    }

    @Override
    public void unregisterClient(Client client) throws ClientNotRegisteredException {
        checkValid();
        realSecretary.unregisterClient(client);
    }

    @Override
    public Instructor hireInstructor(Person p1, int salary, List<SessionType> sessionstype) {
        checkValid();
        return realSecretary.hireInstructor(p1, salary, sessionstype);
    }

    @Override
    public void fireInstructor(Instructor instructor) {
        checkValid();
        realSecretary.fireInstructor(instructor);
    }

    @Override
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor)
            throws InstructorNotQualifiedException {
        checkValid();
        return realSecretary.addSession(sessionType, date, forumType, instructor);
    }

    @Override
    public void deleteSession(Session session) {
        checkValid();
        realSecretary.deleteSession(session);
    }

    @Override
    public void registerClientToLesson(Client client, Session session)
            throws DuplicateClientException, ClientNotRegisteredException {
        checkValid();
        realSecretary.registerClientToLesson(client, session);
    }

    @Override
    public void notify(String message) {
        checkValid();
        realSecretary.notify(message);
    }

    @Override
    public void notify(String date, String message) {
        checkValid();
        realSecretary.notify(date, message);
    }

    @Override
    public void notify(Session session, String message) {
        checkValid();
        realSecretary.notify(session, message);
    }

    @Override
    public void paySalaries() {
        checkValid();
        realSecretary.paySalaries();
    }

    @Override
    public void printActions() {
        checkValid();
        realSecretary.printActions();
    }
    public String toString() {
        checkValid();
        return realSecretary.toString();
    }
}

