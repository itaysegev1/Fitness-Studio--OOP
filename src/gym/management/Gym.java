package gym.management;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.ClientNotRegisteredToGymException;
import gym.Exception.DuplicateClientException;
import gym.Exception.DuplicateClientGymException;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static final Gym gym=new Gym();
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

    protected boolean addClient(Client client) throws DuplicateClientException {
        if(!IsContainClient(client)){
            clients.add(client);
            return true;
        }
        else{
            throw new DuplicateClientGymException();
        }
    }
    protected boolean removeClient(Client client) throws ClientNotRegisteredException {
        if(!IsContainClient(client)){
            throw new ClientNotRegisteredToGymException();
        }
        else{
            removeclient(client);
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

    private boolean IsContainClient(Client c1){
        for(Client c2:clients){
            if(c2.equals(c1)){
                return true;
            }
        }
        return false;
    }
    private boolean IsContainInstructor(Instructor i1){
        for(Instructor i2:instructors){
            if(i1.equals(i2)){
                return true;
            }
        }
        return false;
    }
    private void removeclient(Client client){
        clients.removeIf(c2 -> c2.equals(client));
    }


}
