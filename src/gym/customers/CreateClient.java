package gym.customers;

import gym.Exception.InvalidAgeException;

/**
 * This class is in charge of creating new clients
 * it will be an option just throw that class.
 */
public class CreateClient {
    /**
     * This method check if the action requirement is really to create new client, if it does it create it
     *
     * @param p1 the client will be created by this person
     * @return the client we made.
     * @throws InvalidAgeException if the age of the client is under 18 and he cant register to the Gym
     */
    public static Client do_action(Person p1) throws InvalidAgeException, IllegalArgumentException {
        if (p1.getBirthDate() == null)
            throw new IllegalArgumentException("Invalid birth date");
        if (p1.age() < 18)
            throw new InvalidAgeException("Error: Client must be at least 18 years old to register");
        return new Client(p1);
    }

}
