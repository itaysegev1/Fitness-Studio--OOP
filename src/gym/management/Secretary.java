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

public interface Secretary {
    public int get_monthly_payment();
    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException;
    public void unregisterClient(Client client) throws ClientNotRegisteredException;
    public Instructor hireInstructor(Person p1, int salary, List<SessionType> sessionstype);
    public Instructor fireInstructor(Instructor instructor);
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException;
    public Session deleteSession(Session session);
    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException, ClientNotRegisteredException;
    public void notify(String message);
    public void notify(String date, String message);
    public void notify(Session session, String message);
    public void paySalaries();
    public void printActions();
}
