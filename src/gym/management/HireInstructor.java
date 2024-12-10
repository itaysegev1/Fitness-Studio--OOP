package gym.management;


import gym.customers.Person;
import gym.management.Sessions.CreateInstructor;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.SessionType;

import java.util.List;

class HireInstructor {
    protected static Instructor Do(Person person,  int salary, List<SessionType> sessionTypes) {
        Instructor i= CreateInstructor.do_action(person, salary, sessionTypes);
        Gym gym=Gym.getInstance();
        if(!gym.IsContainInstructor(i)){
            gym.addInstructor(i);
            GymLogger.getInstance().log("Hired new instructor: "+i.getName()+" with salary per hour: "+i.getSalary());
            return i;
        }
        return null;
    }
}
