package gym.management;

import java.util.ArrayList;
import java.util.List;

/**
 * The Gym Logger.
 * it saves all the history of the gym
 */
public class GymLogger {
    private static GymLogger logger = new GymLogger();
    private List<String> log;

    /**
     * private constructor cause there is only one logger
     */
    private GymLogger() {
        log = new ArrayList<>();
    }

    /**
     * @return the instance of the gym logger
     */
    protected static GymLogger getInstance() {
        return logger;
    }

    /**
     * This method adds new message to the logger
     *
     * @param msg the message needed to be added
     */
    protected void log(String msg) {
        this.log.add(msg);
    }

    /**
     * This method go through all the log and print it
     */
    protected void printLog() {
        for (String msg : log) {
            System.out.println(msg);
        }
    }
}
