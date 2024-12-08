package gym.management;

import gym.customers.Client;
import gym.management.Sessions.Session;

import java.util.List;

public class PaySalaries {
    protected static int Do(){
        Gym gym = Gym.getInstance();
        List<Session> sessions=gym.getSessions();
        for(Session session:sessions){
            int salary=session.getInstructor().getSalary();
            session.getInstructor().setBalance(salary);
            gym.paySalary(salary);
        }
        gym.paySalary(gym.getSecretary().get_monthly_payment());
        return gym.getBalance();
    }
}
