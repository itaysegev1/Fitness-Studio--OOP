package gym.management.Sessions;
import gym.customers.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private final SessionType sessionType;
    private LocalDateTime date;
    private ForumType forumType;
    private Instructor instructor;
    List<Client> clients;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    protected Session(SessionType sessionType, String date, ForumType forumType, Instructor instructor) {
        this.instructor = instructor;
        this.sessionType = sessionType;
        this.date = LocalDateTime.parse(date, formatter);
        this.forumType = forumType;
        clients = new ArrayList<Client>();
    }

    /////////////////////// Getters //////////////////////
    protected SessionType getSessionType() {
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
    protected void setDate(LocalDateTime date) {
        this.date = date;
    }
    //////////// Methods //////////////

    protected boolean is_available() {
        return sessionType.getCapacity()>clients.size();
    }
    protected boolean is_sign(Client client) {
        return clients.contains(client);
    }
    protected boolean sign_to_session(Client client) {
        if(is_available()) {
            clients.add(client);
            return true;
        }
        return false;
    }
    protected boolean remove_client(Client client) {
        if(sign_to_session(client)) {
            clients.remove(client);
            return true;
        }
        return false;
    }


}
