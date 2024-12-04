package gym.customers;

import gym.customers.Gender;
import gym.customers.Person;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    protected List<Session>  l;

    private Client(String name, int money, Gender gender, String birth) {
        super(name, money, gender, birth);
        l = new ArrayList<Session>();
    }
    private List<Session> getL() {
        return l;
    }
    private void setL(List<Session> l) {
        this.l = l;
    }
    protected void registertoclass(){

    }

}
