package gym.management;

import gym.Money_Account;
import gym.customers.Client;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class GymData {
    protected static GymData instance = new GymData();
    List<Employ> employList;
    List<Session> sessionList;
    List<Client> clientList;
    Money_Account Balance;

    ///////////////// Constructor //////////////////
    private GymData() {
        employList=new ArrayList<>();
        sessionList=new ArrayList<>();
        clientList=new ArrayList<>();
        Balance=new Money_Account(0);
    }
    protected static GymData getInstance() {
        return instance;
    }

    ////////////////// Getters //////////////////////
    protected List<Employ> getEmployList() {
        return employList;
    }
    protected List<Session> getSessionList() {
        return sessionList;
    }
    protected List<Client> getClientList() {
        return clientList;
    }
    protected Money_Account getBalance() {
        return Balance;
    }

    ////////////////// Setters ///////////////////////
    protected void setBalance(int balance) {
        Balance.addMoney(balance);
    }
    protected void addClient(Client client) {
        clientList.add(client);
    }
    protected void addEmploy(Employ employ) {
        employList.add(employ);
    }
    protected void addSession(Session session) {
        sessionList.add(session);
    }
    protected void removeClient(Client client) {
        clientList.remove(client);
    }
    protected void removeEmploy(Employ employ) {
        employList.remove(employ);
    }
    protected void removeSession(Session session) {
        sessionList.remove(session);
    }
    public String toString(){
        String s = "";
        s += "Gym Balance: " + Balance.getBalance() + "\n";
        s += "\nClients Data:\n";
        for (Client c : clientList) {
            s += c.toString() + "\n";
        }
        s += "\nEmployees Data:\n";
        for (Employ i : employList) {
            s += i.toString() + "\n";
        }
        s += "\nSessions Data:\n";
        for (int i = 0; i < sessionList.size() - 1; i++) {
            s += sessionList.get(i).toString() + "\n";
        }
        {
            s += sessionList.getLast().toString();
        }
        return s;
    }



}
