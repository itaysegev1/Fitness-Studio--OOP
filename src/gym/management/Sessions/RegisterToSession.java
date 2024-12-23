package gym.management.Sessions;

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
    public static void do_action(Session session, Client client) {
        session.addClient(client);
        client.pay_for_class(session.getPrice());
    }
}
