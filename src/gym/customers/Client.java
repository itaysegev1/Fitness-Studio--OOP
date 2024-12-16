package gym.customers;

import gym.management.Observer;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import gym.management.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Client extends Person implements Observer {
    private List<Session>  sessions;
    private List<String> notification;

    /**
     * Constructor for Client, the client just rely on a person
     * @param person - the person that this client is.
     */
    protected Client(Person person) {
        super(person);
        sessions=new ArrayList<>();
        notification=new ArrayList<>();
    }

    //////////////// Getters ///////////////////
    public List<Session> getSessions() {
        return sessions;
    }
    public List <String> getNotifications() {
        return notification;
    }

    /////////////// Setters /////////////////////
    public void pay_for_class(int balance) {
        this.Balance.subMoney(balance);
    }
    protected void addSession(Session session) {
        this.sessions.add(session);
    }
    @Override
    public void update(Subject subject, String message) {
        this.notification.add(message);
    }
    /**
     * Method that check what are the forum types this client is in.
     * @return  a list of all the forum types
     */
    public List<ForumType> getForumTypes() {
        List<ForumType> forumTypes=new ArrayList<>();
        forumTypes.add(ForumType.All);
        if(this.age()>=65)
            forumTypes.add(ForumType.Seniors);
        if(this.getGender().equals(Gender.Male))
            forumTypes.add(ForumType.Male);
        else
            forumTypes.add(ForumType.Female);
        return forumTypes;
    }



}
