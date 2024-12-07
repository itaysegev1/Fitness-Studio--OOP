package gym.management.Sessions;

import gym.Actions;
import gym.customers.Client;

public class RegisterToSession {
    public static void doaction(Actions a, Session session, Client client) {
        if(a.equals(Actions.registerClientToSession)){
            session.addClient(client);
            client.setBalance(session.getSessionType().getPrice());
        }
    }
}
