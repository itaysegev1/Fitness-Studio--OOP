package gym.customers;

import gym.management.Observer;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import gym.management.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Client implements Observer {
    Person p;
    private List<Session>  sessions;
    private List<String> notification;

    /**
     * Constructor for Client, the client just rely on a person
     * @param person - the person that this client is.
     */
    protected Client(Person person) {
        p=person;
        sessions=new ArrayList<>();
        notification=new ArrayList<>();
    }

    //////////////// Getters ///////////////////
    public String getName() {
        return p.getName();
    }
    public int getMoney() {
        return p.getBalance();
    }
    public Gender getGender() {
        return p.getGender();
    }
    protected Date getBirthDate(){
        return p.getBirthDate();
    }
    public List<Session> getSessions() {
        return sessions;
    }
    public List <String> getNotifications() {
        return notification;
    }

    /////////////// Setters /////////////////////
    public void setBalance(int balance) {
        p.setBalance(-balance);
    }
    protected void addSession(Session session) {
        this.sessions.add(session);
    }
    @Override
    public void update(Subject subject, String message) {
        this.notification.add(message);
    }

    /**
     * This method compare between two clients and check if there are the same
     * @param c1- the second person
     * @return - a boolean answer.
     */
    public boolean equals(Client c1){
        return (c1.p.getBirthDate().equals(this.p.getBirthDate()) && c1.getMoney() == this.getMoney()
                && c1.getName().equals(this.getName()) && c1.getGender() == this.getGender());
    }

    /**
     * Method that check what are the forum types this client is in.
     * @return  a list of all the forum types
     */
    public List<ForumType> getForumTypes() {
        List<ForumType> forumTypes=new ArrayList<>();
        forumTypes.add(ForumType.All);
        if(this.p.age()>=65)
            forumTypes.add(ForumType.Seniors);
        if(this.getGender().equals(Gender.Male))
            forumTypes.add(ForumType.Male);
        else
            forumTypes.add(ForumType.Female);
        return forumTypes;
    }

    /**
     * This method return the string of the person that the client is.
     * @return  "ID: | Name: | Gender: | Birthday: | Age: | Balance: "
     */
    public String toString() {
        String s = p.toString();
        return s+"\n";
    }


}
