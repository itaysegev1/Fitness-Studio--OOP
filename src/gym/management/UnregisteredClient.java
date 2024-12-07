package gym.management;

import gym.Exception.ClientNotRegisteredToGymException;
import gym.customers.Client;

class UnregisteredClient {
    protected static void Do(Client client) throws ClientNotRegisteredToGymException {
        Gym gym = Gym.getInstance();
        if(!gym.IsContainClient(client)){
            throw new ClientNotRegisteredToGymException();
        }
        gym.Removeclient(client);
        gym.addHistory("Unregistered client: "+client.getName());
    }
}
