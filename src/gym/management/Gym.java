package gym.management;

import gym.Exception.*;
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
        history_actions.add("A new secretary has started working at the gym: "+p1.getName());
        Secretary s1=Secretary.getInstance();
        if(s1!=null){
            s1.fire_secretary();
        }
        Secretary.setSecretary(p1,salary);
        this.secretary=Secretary.getInstance();
    }

    public Secretary getSecretary(){
        return secretary;
    }

    protected void addClient(Client client) throws DuplicateClientException {
        clients.add(client);
    }

    protected void Removeclient(Client client){
        clients.removeIf(c2 -> c2.equals(client));
    }

    protected void addInstructor(Instructor instructor){
        instructors.add(instructor);
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

    protected boolean sign_to_session(Session session,Client client) throws ClientNotRegisteredException, DuplicateClientException {
        if(!IsContainClient(client))
            throw new ClientCannotRegisteredToClassException();
        if(session.getClients().contains(client)){
            throw new DuplicateClientLessonException();
        }
        if(session.sign_to_session(client)) {
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

    protected boolean IsContainClient(Client c1){
        for(Client c2:clients){
            if(c2.equals(c1)){
                return true;
            }
        }
        return false;
    }

    protected boolean IsContainInstructor(Instructor i1){
        for(Instructor i2:instructors){
            if(i1.equals(i2)){
                return true;
            }
        }
        return false;
    }
    protected boolean IsContainSession(Session s1){
        for(Session s2:sessions){
            if(s2.equals(s1)){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        String s= "Gym Name: "+name+"\n";
        s+="Gym Secretary: "+secretary;
        s+="Gym Balance: "+balance+"\n";
        s+="\nClients Data:\n";
        for(Client c:clients){
            s+=c.toString();
        }
        s+="\nEmployees Data:\n";
        for(Instructor i:instructors){
            s+=i.toString();
        }
        s+=secretary.toString();
        s+="\nSessions Data:\n";
        for (Session session : sessions) {
            s+=session.toString();
        }
        return s;
    }
}
