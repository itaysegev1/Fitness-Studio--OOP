package gym.management;

/**
 * This is an interface for observers Object
 * each observer need to implement this method
 */
public interface Observer {
    /**
     * This method gets the subject that the message is received from, and the message they needed to notify us
     *
     * @param subject the subject that the message received from
     * @param message the message
     */
    void update(Subject subject, String message);
}
