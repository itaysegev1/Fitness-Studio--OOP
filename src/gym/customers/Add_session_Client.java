package gym.customers;

import gym.Actions;
import gym.management.Sessions.Session;

public class Add_session_Client {
    public static void Do(Client client, Session session, Actions actions){
        if(actions == Actions.register_client_to_session)
            client.addSession(session);
    }
}
