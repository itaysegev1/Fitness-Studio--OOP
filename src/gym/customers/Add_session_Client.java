package gym.customers;

import gym.management.Sessions.Session;

public class Add_session_Client {
    public static void Do(Client client, Session session){
        client.addSession(session);
    }
}
