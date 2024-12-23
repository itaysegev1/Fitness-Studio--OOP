package gym.management;

import gym.Exception.DuplicateClientException;
import gym.Exception.InvalidAgeException;
import gym.customers.Client;
import gym.customers.CreateClient;
import gym.customers.Person;

/**
 * This class is taking charge on register clients to the gym
 */
class RegisterClient {
    /**
     * In this method we created a new client (only if he is above 18 years old, and not already in the gym)
     * and added him to the gym.
     *
     * @param person that the client is created from
     * @return the client that has been added
     * @throws InvalidAgeException      if the person is under 18 years old
     * @throws DuplicateClientException if the client already registered to the gym
     */
    protected static Client Do(Person person) throws InvalidAgeException, DuplicateClientException {
        try {
            Client client = CreateClient.do_action(person);
            Gym gym = Gym.getInstance();
            if (gym.IsContainClient(client))
                throw new DuplicateClientException("Error: The client is already registered");
            gym.addClient(client);
            GymLogger.getInstance().log("Registered new client: " + client.getName());
            return client;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
