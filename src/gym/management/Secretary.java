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
    /**
     * This method returns the monthly payment the secretary gets
     * @return the salary per month
     */
    public int get_monthly_payment();

    /**
     * This method charge on register clients to the gym
     * @param person the person need to register
     * @return the client that registered
     * @throws InvalidAgeException if the person is under 18 years old
     * @throws DuplicateClientException if the client already registered to the gym
     */
    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException;

    /**
     * This method charge on unregister clients to the gym
     * @param client the client that need to be removed
     * @throws ClientNotRegisteredException if the client not registered to the gym
     */
    public void unregisterClient(Client client) throws ClientNotRegisteredException;

    /**
     * This method charge on hire new instructor to the gym
     * @param person the person that need to be the instructor
     * @param salary the salary per hour that the instructor get
     * @param sessionstype a list of session types the instructor can coach
     * @return the instructor that hired to the gym
     */
    public Instructor hireInstructor(Person person, int salary, List<SessionType> sessionstype);

    /**
     * This method charge on fire instructor from the gym
     * @param instructor the instructor need to be fired
     */
    public void fireInstructor(Instructor instructor);

    /**
     * This method charge on adding new sessions to the gym
     * @param sessionType the type of the session need to be created
     * @param date the date and the hour of the session ("dd-MM-yyyy HH:MM")
     * @param forumType the forum type the session is for
     * @param instructor the instructor that coach this session
     * @return the session that have been created
     * @throws InstructorNotQualifiedException if the instructor cannot coach this session
     */
    public Session addSession(SessionType sessionType, String date, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException;

    /**
     * This method charge on delete a session from the gym
     * @param session the session need to be deleted
     */
    public void deleteSession(Session session);

    /**
     * This method charge on register a client to an existing session
     * @param client the client that try to register
     * @param session the session the client try to register to
     * @throws DuplicateClientException if the client already registered to the session
     * @throws ClientNotRegisteredException if the client not registered to the gym
     */
    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException, ClientNotRegisteredException;

    /**
     * This method charge on notify all the clients of the gym a message
     * @param message the message need to be notified
     */
    public void notify(String message);

    /**
     * This method charge on notify all the clients that registered to a session in the date was given
     * @param date all the sessions on that date will be notified
     * @param message the message need to be notified
     */
    public void notify(String date, String message);

    /**
     * This method charge on notify all the clients that registered to a session
     * @param session all the clients on that session will be notified
     * @param message the message need to be notified
     */
    public void notify(Session session, String message);

    /**
     * This method charge on pay the salaries for all the employs
     */
    public void paySalaries();

    /**
     * This method charge on printing all the actions that has been happened in the gym
     */
    public void printActions();
}
