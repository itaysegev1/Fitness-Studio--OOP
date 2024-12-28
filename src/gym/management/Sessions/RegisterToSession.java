package gym.management.Sessions;

import gym.Actions;
import gym.customers.Add_session_Client;
import gym.customers.Client;

/**
 * This class is taking charge of register client to lesson
 */
public class RegisterToSession {
    /**
     * This method register the client to this lesson
     *
     * @param session the session we want to register to
     * @param client  the client we want to register to the lesson
     */
    public static void do_action(Session session, Client client, Actions action) {
        if(action==Actions.register_client_to_session) {
            session.addClient(client);
            Add_session_Client.Do(client, session,action);
            client.pay_for_class(session.getPrice());
        }
    }
}
