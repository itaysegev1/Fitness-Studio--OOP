package gym.management;

import gym.Exception.ClientCannotRegisteredToClassException;
import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.DuplicateClientLessonException;
import gym.customers.Client;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import java.time.LocalDateTime;
import java.util.List;

class RegisterClientToLesson {
    protected static boolean Do(Session session, Client client) throws ClientNotRegisteredException, DuplicateClientException {
        if(is_registered_to_gym_check(session,client) && get_enough_money_check(session,client)
                && is_not_registered_check(session,client) && forum_type_check(session,client)
                && is_in_future_check(session,client) && have_enough_space_check(session)){
            //////////// fix after here ///////////
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
            if(forumType_S.equals(ForumType.Male) || forumType_S.equals(ForumType.Female))
                gym.addHistory("Failed registration: Client's gender doesn't match the session's gender requirements");

            if(forumType_S.equals(ForumType.Seniors))
                gym.addHistory("Failed registration: Client doesn't meet the age requirements for this session (Seniors)");
            return false;
        }
    }

    private static boolean get_enough_money_check(Session session, Client client) {
        if (client.getMoney()>session.getSessionType().getPrice())
            return true;
        Gym.getInstance().addHistory("Failed registration: Client doesn't have enough balance");
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
        if(session.getDate().isAfter(now)){
            Gym.getInstance().addHistory("Failed registration: Session is not in the future");
            return false;
        }
        return true;
    }

    private static boolean have_enough_space_check(Session session) {
        if (!session.is_available()){
            Gym.getInstance().addHistory("Failed registration: No available spots for session");
            return false;
        }
        return true;

    }
}
