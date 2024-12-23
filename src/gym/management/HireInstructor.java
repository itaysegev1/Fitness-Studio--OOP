package gym.management;


import gym.customers.Person;
import gym.management.Sessions.CreateInstructor;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.SessionType;

import java.util.List;

/**
 * This class taking charge of hiring new instructor
 */
class HireInstructor {
    /**
     * This method get all the things it needs to create new instructor
     * and if it is not in the gym already it will be created
     *
     * @param person       the person that the instructor is created from
     * @param salary       salary per hour
     * @param sessionTypes list of session types it can coach
     * @return the new instructor
     */
    protected static Instructor Do(Person person, int salary, List<SessionType> sessionTypes) {
        try {
            Instructor i = CreateInstructor.do_action(person, salary, sessionTypes);
            Gym gym = Gym.getInstance();
            if (!gym.IsContainInstructor(i)) {
                gym.addInstructor(i);
                GymLogger.getInstance().log("Hired new instructor: " + i.getName() + " with salary per hour: " + i.getSalary());
                return i;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
