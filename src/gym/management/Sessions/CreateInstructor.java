package gym.management.Sessions;

import gym.Actions;
import gym.customers.Person;

import java.util.List;

/**
 * This class charge on creating instructors.
 */
public class CreateInstructor {
    /**
     * This method check if the action requirement is really to create new instructor, if it does it create it
     * @param a- the action we want to make
     * @param p1- the instructor will be created by this person
     * @param salary -the instructor salary per hour
     * @param sessionTypes - the session type that the instructor can do.
     * @return - the instructor we made.
     */
    public static Instructor do_action(Actions a, Person p1, int salary, List<SessionType> sessionTypes){
        if (a == Actions.hireInstructor) {
            return new Instructor(p1,salary,sessionTypes);
        }
        return null;
    }
}
