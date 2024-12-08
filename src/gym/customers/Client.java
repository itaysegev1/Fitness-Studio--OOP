package gym.customers;
import java.time.LocalDateTime;

import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
    Person p;
    protected List<Session>  sessions;
    private List<String> notification;

    protected Client(Person person) {
        p=person;
        sessions=new ArrayList<>();
        notification=new ArrayList<>();
    }
    public String getName() {
        return p.getName();
    }
    public int getMoney() {
        return p.getMoney();
    }
    public Gender getGender() {
        return p.getGender();
    }
    protected Date getBirthDate(){
        return p.getBirthDate();
    }
    public void setBalance(int balance) {
        p.setBalance(-balance);
    }

    protected List<Session> getSessions() {
        return sessions;
    }

    protected void addSession(Session session) {
        this.sessions.add(session);
    }



    public List <String> getNotifications() {
        return notification;
    }

    protected void notification(){

    }

    public boolean equals(Client c1){
        return (c1.p.getBirthDate().equals(this.p.getBirthDate()) && c1.getMoney() == this.getMoney()
                && c1.getName().equals(this.getName()) && c1.getGender() == this.getGender());
    }

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
    public String toString() {
        String s = p.toString();
        return s+"\n";
    }
}
