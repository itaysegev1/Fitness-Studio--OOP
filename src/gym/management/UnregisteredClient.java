package gym.management;

import gym.Exception.ClientNotRegisteredToGymException;
import gym.customers.Client;

/**
 * This class taking charge on Unregister client from the gym
 */
class UnregisteredClient {
    /**
     * This method check if this client is register to the gym and if it does
     * it will be removed
     * @param client The client needed to be removed
     * @throws ClientNotRegisteredToGymException if the client is not register to the gym
     */
    protected static void Do(Client client) throws ClientNotRegisteredToGymException {
        Gym gym = Gym.getInstance();
        if(!gym.IsContainClient(client)){
            throw new ClientNotRegisteredToGymException();
        }
        gym.RemoveClient(client);
        GymLogger.getInstance().log("Unregistered client: "+client.getName());
    }
}
