package gym.management;

import java.util.List;

/**
 * This class is taking charge on all the payment for the employs.
 */
public class PaySalaries {
    /**
     * In this method we go through all the instructors and give them pay per lesson they coached
     * and pay the secretary her salary.
     */
    protected static void Do(List<Employ>employs) {
        Gym gym = Gym.getInstance();
        for (Employ i : employs) {
            gym.paySalary(i.get_paid());
        }
    }
}
