package gym.customers;
import java.time.LocalDate;
import java.time.LocalDateTime;
import gym.customers.Gender;
import gym.customers.Person;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    protected List<Session>  l;

    public Client(String name, int money, Gender gender, String birth) {
        super(name, money, gender, birth);
        l = new ArrayList<Session>();
    }
    public Client(Person person) {
        super(person);
        l=new ArrayList<>();
    }
    private List<Session> getL() {
        return l;
    }

    private void setL(List<Session> l) {
        this.l = l;
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
            int age = LocalDate.now().getYear() - this.birth.getYear();
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
    protected void notification(){

    }
}
