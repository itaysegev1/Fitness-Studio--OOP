package gym.management.Sessions;
import gym.customers.*;
import gym.management.Gym;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Session {
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
    }
    //////////// Methods //////////////

    public boolean is_available() {
        return sessionType.getCapacity()>clients.size();
    }

    protected boolean is_over(){
        LocalDate today = LocalDate.now();
        return today.isBefore(ChronoLocalDate.from(date));
    }
    protected boolean is_sign(Client client) {
        return clients.contains(client);
    }
    public boolean sign_to_session(Client client) {
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

    public boolean equals(Session session) {
        return (this.getSessionType().equals(session.getSessionType()) && this.getDate().equals(session.getDate())
                && this.getForumType().equals(session.getForumType()) && this.getInstructor().equals(session.getInstructor()));
    }


}
