package gym.management;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class is taking charge on all the notify messages
 * it holds all the observers on this subclass and notify them a message when they needed to
 */
public abstract class Subject {
    private List<Observer>observers=new ArrayList<>();

    /**
     * Adding new observer to the observers of this class
     * @param observer the observer needed to be added
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removing this observer from the observers of this class
     * @param observer the observer needed to be removed
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * going through all the observers and notify them the message.
     * @param message the message that needed to be sent
     */
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(this,message);
        }
    }
}
