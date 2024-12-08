package gym.management;
import gym.Actions;
import gym.Exception.DuplicateClientException;
import gym.Exception.DuplicateClientGymException;
import gym.Exception.InvalidAgeException;
import gym.customers.Client;
import gym.customers.CreateClient;
import gym.customers.Person;

class RegisterClient {
    protected static Client Do(Person person) throws InvalidAgeException, DuplicateClientException {
        Client client= CreateClient.doaction(Actions.registerClient,person);
        Gym gym=Gym.getInstance();
        if(gym.IsContainClient(client))
            throw new DuplicateClientGymException();
        gym.addClient(client);
        GymLogger.getInstance().log("Registered new client: "+client.getName());
        return client;
    }
}
