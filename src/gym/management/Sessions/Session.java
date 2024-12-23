package gym.management.Sessions;

import gym.customers.*;
import gym.management.Subject;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract class that set 2 methods of the under sessions need to return, their price and capacity
 * in this class we are creating all the share methods of all the lessons types
 */
public abstract class Session extends Subject {
    private LocalDateTime date;
    private ForumType forumType;
    private Instructor instructor;
    private List<Client> clients;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    /**
     * a regular instructor of lesson, can be called just from subclasses because this is an abstract class
     *
     * @param date       the date of the lesson
     * @param forumType  the forum type of this lesson
     * @param instructor the instructor of the lesson
     */
    protected Session(String date, ForumType forumType, Instructor instructor) throws DateTimeParseException {
        this.instructor = instructor;
        this.date = LocalDateTime.parse(date, formatter);
        this.forumType = forumType;
        clients = new ArrayList<Client>();

    }

    /// //////////////////// Abstract Methods //////////////
    public abstract int getPrice();

    public abstract int getCapacity();


    /// //////////////////// Getters //////////////////////
    public LocalDateTime getDate() {
        return date;
    }

    public ForumType getForumType() {
        return forumType;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Client> getClients() {
        return clients;
    }

    /// //////////////////// Setters /////////////////
    protected void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    protected void setDate(String date) {
        this.date = LocalDateTime.parse(date, formatter);
    }

    protected void addClient(Client client) {
        clients.add(client);
        this.attach(client);
    }
    //////////// Methods //////////////

    /**
     * check if the session didnt get to the capacity yet
     *
     * @return true if the lesson still available
     */
    public boolean is_available() {
        return this.getCapacity() > clients.size();
    }

    /**
     * This method checks if this session and other session are the same.
     *
     * @param session the session we compare to
     * @return a boolean answer if they are the same or not
     */
    public boolean equals(Session session) {
        return (this.getClass().equals(session.getClass()) && this.getDate().equals(session.getDate())
                && this.getForumType().equals(session.getForumType()) && this.getInstructor().equals(session.getInstructor()));
    }

    /**
     * creating a string that describe this class:
     * Session Type:  | Date:  | Forum:  | Instructor:  | Participants: "
     *
     * @return the string that describe the class
     */
    public String toString() {
        String d = formatter.format(date);
        String p = (clients.size()) + "/" + (this.getCapacity());
        String s = "Session Type: " + this.getClass().getSimpleName() + " | Date: " + d + " | Forum: " + this.forumType + " | Instructor: "
                + this.instructor.getName() + " | Participants: " + p;
        return s;
    }

    /**
     * This method responsible to announce all the members of this class a message from the gym.
     *
     * @param message the message we want to send to all the members of the class
     */
    public void notify(String message) {
        this.notifyObservers(message);
    }
}
