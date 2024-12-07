package gym.management;

import gym.Actions;
import gym.customers.Person;
import gym.management.Sessions.CreateInsructor;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.SessionType;

import java.util.List;

class HireInstructor {
    protected static Instructor Do(Person person,  int salary, List<SessionType> sessionTypes) {
        Instructor i= CreateInsructor.doaction(Actions.hireInstructor, person, salary, sessionTypes);
        Gym gym=Gym.getInstance();
        if(!gym.IsContainInstructor(i)){
            gym.addInstructor(i);
            gym.addHistory("Hired new instructor: "+i.getName()+" with salary per hour: "+i.getSalary());
            return i;
        }
        return null;
    }
}
