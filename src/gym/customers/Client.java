package gym.customers;

import gym.customers.Gender;
import gym.customers.Person;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    protected List<Session>  l;

    public Client(String name, int money, Gender gender, String birth) {
        super(name, money, gender, birth);
        l = new ArrayList<Session>();
        Client c1 = new Client(name, money, gender, birth);
    }
    public List<Session> getL() {
        return l;
    }
    public void setL(List<Session> l) {
        this.l = l;
    }
    public static void registertoclass(){

    }

}
