package gym.customers;
import java.time.LocalDateTime;

import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    protected List<Session>  sessions;
    private List<String> notification;

    protected Client(Person person) {
        super(person);
        sessions=new ArrayList<>();
        notification=new ArrayList<>();
    }
    protected List<Session> getSessions() {
        return sessions;
    }

    protected void addSession(Session session) {
        this.sessions.add(session);
    }

    /***
     * this function return true if its valid to register this client to
     * the specific time, else false.
     * the secretary will sign him
     * @param adds
     * @return
     */
    protected boolean registertoclass(Session adds){
        if(adds.getDate().equals(LocalDateTime.now())){
            if (canregistertoclass(adds)){
                //register client to this class
                return true;
            }
        }
        return false;
    }

    /***
     * a boolean function that returns true if the client is legal lto enter a session
     * and false otherwise
     * @param adds
     * @return
     */
    private boolean canregistertoclass(Session adds){
        //at the end ill add try and catch
        if(adds.getForumType()== ForumType.Seniors){
            int age = this.age();
            if(age >= 65){
                return true;
            }
        }
        if(adds.getForumType()== ForumType.Male){
            if(this.gender == Gender.Male){
                return true;
            }
        }
        if(adds.getForumType()== ForumType.Female){
            if(this.gender == Gender.Female){
                return true;
            }
        }
        if(adds.getForumType()== ForumType.All){
            return true;
        }
        return false;

    }
    public List <String> getNotifications() {
        return notification;
    }

    protected void notification(){

    }

    public boolean equals(Client c1){
        return (c1.getBirthDate().equals(this.getBirthDate()) && c1.getMoney() == this.getMoney()
                && c1.getName().equals(this.getName()) && c1.getGender() == this.getGender());
    }

    public List<ForumType> getForumTypes() {
        List<ForumType> forumTypes=new ArrayList<>();
        forumTypes.add(ForumType.All);
        if(this.age()>=65)
            forumTypes.add(ForumType.Seniors);
        if(this.gender.equals(Gender.Male))
            forumTypes.add(ForumType.Male);
        else
            forumTypes.add(ForumType.Female);
        return forumTypes;
    }
}
