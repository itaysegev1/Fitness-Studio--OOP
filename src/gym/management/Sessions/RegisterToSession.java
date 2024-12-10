package gym.management.Sessions;

import gym.customers.Client;

/**
 * This class is taking charge of register client to lesson
 */
public class RegisterToSession {
    /**
     * This method register the client to this lesson
     * @param a- the action of the method
     * @param session - the session we want to register to
     * @param client - the client we want to register to the lesson
     */
    public static void do_action(Session session, Client client) {
        session.addClient(client);
        client.setBalance(session.getPrice());
    }
}
