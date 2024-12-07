package gym.management.Sessions;

import gym.Actions;
import gym.Exception.InvalidAgeException;
import gym.customers.Client;
import gym.customers.Person;

import java.util.List;

public class CreateInsructor {
    public static Instructor doaction(Actions a, Person p1, int salary, List<SessionType> sessionTypes){
        if (a == Actions.hireInstructor) {
            return new Instructor(p1,salary,sessionTypes);
        }
        return null;
    }
}
