package gym.management;

import gym.Exception.ClientNotRegisteredException;
import gym.customers.Client;

/**
 * This class taking charge on Unregister client from the gym
 */
class UnregisteredClient {
    /**
     * This method check if this client is register to the gym and if it does
     * it will be removed
     * @param client The client needed to be removed
     * @throws ClientNotRegisteredException if the client is not register to the gym
     */
    protected static void Do(Client client) throws ClientNotRegisteredException {
        Gym gym = Gym.getInstance();
        if(!gym.IsContainClient(client)){
            throw new ClientNotRegisteredException("Error: Registration is required before attempting to unregister");
        }
        gym.RemoveClient(client);
        GymLogger.getInstance().log("Unregistered client: "+client.getName());
    }
}
