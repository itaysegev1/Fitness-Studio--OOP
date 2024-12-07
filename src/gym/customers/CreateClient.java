package gym.customers;

import gym.Exception.InvalidAgeException;
import gym.Actions;

public class CreateClient {
    public static Client doaction(Actions a,Person p1) throws InvalidAgeException {
        if (a == Actions.registerClient) {
            if (p1.age() < 18)
                throw new InvalidAgeException();
            return new Client(p1);
        }
        return null;
    }

}
