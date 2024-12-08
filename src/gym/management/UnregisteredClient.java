package gym.management;

import gym.Exception.ClientNotRegisteredToGymException;
import gym.customers.Client;

class UnregisteredClient {
    protected static Client Do(Client client) throws ClientNotRegisteredToGymException {
        Gym gym = Gym.getInstance();
        if(!gym.IsContainClient(client)){
            throw new ClientNotRegisteredToGymException();
        }
        gym.Removeclient(client);
        GymLogger.getInstance().log("Unregistered client: "+client.getName());
        return client;
    }
}
