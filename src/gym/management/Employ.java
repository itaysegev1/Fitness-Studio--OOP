package gym.management;

/**
 * This class is a simple interface to all employs in the gym
 */
public interface Employ {

    /**
     * This Method take care of paying this employ his salary
     * @return the salary that have been paid to the employ
     */
    public int get_paid();

    /**
     * @return A string that describe this employ
     */
    public String toString();

}
