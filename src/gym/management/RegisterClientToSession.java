package gym.management;

import gym.Actions;
import gym.Exception.ClientCannotRegisteredToClassException;
import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.DuplicateClientLessonException;
import gym.customers.Client;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.RegisterToSession;
import gym.management.Sessions.Session;
import java.time.LocalDateTime;
import java.util.List;

class RegisterClientToSession {
    protected static boolean Do(Session session, Client client) throws ClientNotRegisteredException, DuplicateClientException {
        boolean canRegister = true;

        if (!is_registered_to_gym_check(session, client)) {
            canRegister = false;
        }
        if (!is_in_future_check(session, client)) {
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
        if(canRegister){
            RegisterToSession.do_action(Actions.registerClientToSession,session,client);
            GymLogger.getInstance().log("Registered client: "+client.getName()+" to session: "
                    +session.getSessionType()+" on "+session.getDate()+" for price: "+session.getSessionType().getPrice());
            Gym.getInstance().payforclass(session.getSessionType().getPrice());
            return true;
        }
        return false;
    }

    private static boolean forum_type_check(Session session, Client client) {
        List<ForumType> forumTypes_C=client.getForumTypes();
        ForumType forumType_S=session.getForumType();
        Gym gym=Gym.getInstance();
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

    private static boolean get_enough_money_check(Session session, Client client) {
        if (client.getMoney()>=session.getSessionType().getPrice())
            return true;
        GymLogger.getInstance().log("Failed registration: Client doesn't have enough balance");
        return false;
    }

    private static boolean is_not_registered_check(Session session, Client client) throws DuplicateClientLessonException {
        List<Client> clients=session.getClients();
        for(Client c:clients){
            if(c.equals(client)){
                throw new DuplicateClientLessonException();
            }
        }
        return true;
    }

    private static boolean is_registered_to_gym_check(Session session, Client client)
            throws ClientCannotRegisteredToClassException {
        Gym gym=Gym.getInstance();
        if(!gym.IsContainClient(client))
            throw new ClientCannotRegisteredToClassException();
        return true;
    }

    private static boolean is_in_future_check(Session session, Client client) {
        LocalDateTime now=LocalDateTime.now();
        if(session.getDate().isBefore(now)){
            GymLogger.getInstance().log("Failed registration: Session is not in the future");
            return false;
        }
        return true;
    }

    private static boolean have_enough_space_check(Session session) {
        if (!session.is_available()){
            GymLogger.getInstance().log("Failed registration: No available spots for session");
            return false;
        }
        return true;

    }
}
