package gym.management;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.customers.Client;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.RegisterToSession;
import gym.management.Sessions.Session;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class taking charge on register an exist client to a session
 */
class RegisterClientToSession {
    /**
     * in this method at first we check if the client can register the session, and if he can register with
     * all the conditions it will register him to the session
     * @param session the session that the client try to register to
     * @param client the client that try to register the lesson
     * @throws ClientNotRegisteredException if the client not register to the gym
     * @throws DuplicateClientException if the client is already register to the session
     */
    protected static void Do(Session session, Client client) throws ClientNotRegisteredException, DuplicateClientException {
        boolean canRegister = true;

        if (!is_registered_to_gym_check(client)) {
            canRegister = false;
        }
        if (!is_in_future_check(session)) {
            canRegister = false;
        }
        if (!forum_type_check(session, client)) {
            canRegister = false;
        }
        if (!get_enough_money_check(session, client)) {
            canRegister = false;
        }
        if (!is_not_registered_check(session, client)) {
            canRegister = false;
        }
        if (!have_enough_space_check(session)) {
            canRegister = false;
        }
        if(!not_registered_to_other_lesson(session, client)) {
            canRegister = false;
        }
        if(canRegister){
            RegisterToSession.do_action(session,client);
            GymLogger.getInstance().log("Registered client: "+client.getName()+" to session: "
                    +session.getClass().getSimpleName()+" on "+session.getDate()+" for price: "+session.getPrice());
            Gym.getInstance().payforclass(session.getPrice());
        }
    }

    /**
     * This method checks if the client is match to the forum types of the session
     * @param session the session that the client need to register to
     * @param client the client that trying to register
     * @return True if the client allowed to register to this forum type
     */
    private static boolean forum_type_check(Session session, Client client) {
        List<ForumType> forumTypes_C=client.getForumTypes();
        ForumType forumType_S=session.getForumType();
        if (forumTypes_C.contains(forumType_S)) {
            return true;
        }
        else{
            if(forumType_S.equals(ForumType.Male) || forumType_S.equals(ForumType.Female)) {
                GymLogger.getInstance().log("Failed registration: Client's gender doesn't match the session's gender requirements");
            }

            if(forumType_S.equals(ForumType.Seniors)) {
                GymLogger.getInstance().log("Failed registration: Client doesn't meet the age requirements for this session (Seniors)");
            }
            return false;
        }
    }

    /**
     *This method checks if the client have enough money to pay for the session
     * @param session the session that the client need to register to
     * @param client the client that trying to register
     * @return True if the client have enough money
     */
    private static boolean get_enough_money_check(Session session, Client client) {
        if (client.getMoney()>=session.getPrice())
            return true;
        GymLogger.getInstance().log("Failed registration: Client doesn't have enough balance");
        return false;
    }

    /**
     * This method checks if the client is already registered to the session
     * @param session the session that the client need to register to
     * @param client the client that trying to register
     * @return True if the client not registered to the lesson
     * @throws DuplicateClientException if the client register to the session already
     */
    private static boolean is_not_registered_check(Session session, Client client) throws DuplicateClientException {
        List<Client> clients=session.getClients();
        for(Client c:clients){
            if(c.equals(client)){
                throw new DuplicateClientException("Error: The client is already registered for this lesson");
            }
        }
        return true;
    }

    /**
     * This method checks if the client is register with the gym
     * @param client the client that trying to register
     * @return True if the client register to the gym
     * @throws ClientNotRegisteredException if the client not registered to the gym
     */
    private static boolean is_registered_to_gym_check(Client client)
            throws ClientNotRegisteredException {
        Gym gym=Gym.getInstance();
        if(!gym.IsContainClient(client))
            throw new ClientNotRegisteredException("Error: The client is not registered with the gym and cannot enroll in lessons");
        return true;
    }

    /**
     * This method check if the session is in the future
     * @param session the session that the client need to register to
     * @return True if the session is in the future
     */
    private static boolean is_in_future_check(Session session) {
        LocalDateTime now=LocalDateTime.now();
        if(session.getDate().isBefore(now)){
            GymLogger.getInstance().log("Failed registration: Session is not in the future");
            return false;
        }
        return true;
    }

    /**
     * This method checks if the session have enough space for more client to register
     * @param session the session that the client need to register to
     * @return True if there is enough space
     */
    private static boolean have_enough_space_check(Session session) {
        if (!session.is_available()){
            GymLogger.getInstance().log("Failed registration: No available spots for session");
            return false;
        }
        return true;

    }

    /**
     * This method checks if the client not registered to othe session on the same time.
     * @param session the session that the client need to register to
     * @param client the client that trying to register
     * @return True if the client not register to other session on this session time
     */
    private static boolean not_registered_to_other_lesson(Session session, Client client) {
        List<Session>sessions=client.getSessions();
        for (Session s:sessions){
            if(s.getDate().equals(session.getDate())){
                return false;
            }
        }
        return true;
    }
}
