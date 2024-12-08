package gym.management;

import gym.Actions;
import gym.Exception.*;
import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.List;
import java.util.Objects;

class FactoryOfActions {
    /**
     * List for Hire instructor - list(0)-Action, list(1)- person, list(2)- int salary, list(3)-list of sessionTypes
     * List for Register Client - List(0)- Action, list(1) -person
     * list for Unregister Client - list(0)- Action, list(1)- Client
     * list for Add Session - list(0)- Action, list(1)- SessionType, list(2)- String date, list(3)- ForumType,
     *                        list(4)- Instructor
     * list for Register Client to Lesson - list(0)-Action, list(1)-Session, list(2)- Client
     * @param list- in order that is always the same
     */
    protected static Object createActions(List <Object> list)
            throws InstructorNotQualifiedException, InvalidAgeException, DuplicateClientException, ClientNotRegisteredException {
        if(!list.isEmpty()){
            if(list.get(0).equals(Actions.hireInstructor)){
                return HireInstructor.Do((Person) list.get(1),(int)list.get(2),(List<SessionType>)list.get(3));
            }
            if(list.get(0).equals(Actions.registerClient)){
                return RegisterClient.Do((Person)list.get(1));
            }
            if((list.get(0)).equals(Actions.unregisterClient)){
                return UnregisteredClient.Do((Client) list.get(1));
            }
            if(list.get(0).equals(Actions.addSession)){
                return AddSession.Do((SessionType)list.get(1),(String) list.get(2),(ForumType) list.get(3),(Instructor) list.get(4));
            }
            if((list.get(0)).equals(Actions.registerClientToSession)){
                return RegisterClientToSession.Do((Session)list.get(1),(Client) list.get(2));
            }
            if(list.get(0).equals(Actions.paySalaries)){
                return PaySalaries.Do();
            }
        }
        return null;
    }
}
