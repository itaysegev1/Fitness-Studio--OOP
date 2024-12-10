package gym.management.Sessions;
import gym.customers.*;
import gym.management.Subject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Session extends Subject {
    private final SessionType sessionType;
    private LocalDateTime date;
    private ForumType forumType;
    private Instructor instructor;
    private List<Client> clients;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    protected Session(SessionType sessionType, String date, ForumType forumType, Instructor instructor) {
        this.instructor = instructor;
        this.sessionType = sessionType;
        this.date = LocalDateTime.parse(date, formatter);
        this.forumType = forumType;
        clients = new ArrayList<Client>();

    }
    /////////////////////// Abstract Methods //////////////
    public abstract int getPrice();
    public abstract int getCapacity();


    /////////////////////// Getters //////////////////////
    public SessionType getSessionType() {
        return sessionType;
    }
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

    /////////////////////// Setters /////////////////
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
     * @return true if the lesson still available
     */
    public boolean is_available() {
        return this.getCapacity()>clients.size();
    }

    public boolean equals(Session session) {
        return (this.getSessionType().equals(session.getSessionType()) && this.getDate().equals(session.getDate())
                && this.getForumType().equals(session.getForumType()) && this.getInstructor().equals(session.getInstructor()));
    }

    public String toString() {
        String d=formatter.format(date);
        String p=(clients.size())+"/"+(this.getCapacity());
        String s="Session Type: "+this.getSessionType()+" | Date: "+d+" | Forum: "+this.forumType+" | Instructor: "
                +this.instructor.getName()+" | Participants: "+p;
        return s+"\n";
    }

    public void notify(String message) {
        this.notifyObservers(message);
    }
}
