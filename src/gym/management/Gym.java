package gym.management;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.ClientNotRegisteredToGymException;
import gym.Exception.DuplicateClientException;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym gym=new Gym();
    private Secretary secretary;
    private int balance;
    private String name;
    private List<Client> clients;
    private List<Instructor> instructors;
    private List<Session> sessions;
    private List <String>history_actions;
    private Gym(){
        balance=0;
        clients=new ArrayList<>();
        instructors=new ArrayList<>();
        sessions=new ArrayList<>();
        history_actions=new ArrayList<>();
    }
    public static Gym getInstance(){
        return gym;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSecretary(Person p1,int salary){
        Secretary.setSecretary(p1,salary);
        this.secretary=Secretary.getInstance();
    }
    public Secretary getSecretary(){
        return secretary;
    }
    protected boolean addClient(Client client) {
        if(!clients.contains(client)){
            clients.add(client);
            return true;
        }
        return false;
    }
    protected boolean removeClient(Client client) throws ClientNotRegisteredException {
        if(!clients.contains(client)){
            throw new ClientNotRegisteredToGymException();
        }
        else{
            clients.remove(client);
            return true;
        }
    }
    protected boolean addInstructor(Instructor instructor){
        if(!instructors.contains(instructor)){
            instructors.add(instructor);
            return true;
        }
        return false;
    }
    protected boolean removeInstructor(Instructor instructor){
        if(instructors.contains(instructor)){
            instructors.remove(instructor);
            return true;
        }
        return false;
    }
    protected boolean addSession(Session session){
        if(!sessions.contains(session)){
            sessions.add(session);
            return true;
        }
        return false;
    }
    protected boolean removeSession(Session session){
        if(sessions.contains(session)){
            sessions.remove(session);
            return true;
        }
        return false;
    }
    protected void addHistory(String action){
        history_actions.add(action);
    }
    protected List<String>getHistory(){
        return history_actions;
    }



}
