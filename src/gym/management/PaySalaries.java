package gym.management;

import gym.management.Sessions.Session;

import java.util.List;

/**
 * This class is taking charge on all the payment for the employs.
 */
public class PaySalaries {
    /**
     * In this method we go through all the instructors and give them pay per lesson they coached
     * and pay the secretary her salary.
     */
    protected static void Do(){
        Gym gym = Gym.getInstance();
        List<Session> sessions=gym.getSessions();
        for(Session session:sessions){
            int salary=session.getInstructor().getSalary();
            session.getInstructor().pay_for_class(salary);
            gym.paySalary(salary);
        }
        gym.paySalary(gym.getSecretary().get_monthly_payment());
    }
}
