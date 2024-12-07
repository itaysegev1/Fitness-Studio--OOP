package gym.management;

import gym.Actions;
import gym.customers.Person;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.SessionType;

import java.util.List;
import java.util.Objects;

class FactoryOfActions {
    /**
     * List for Hire instructor - list(0)-Action, list(1)- person, list(3)- int salary, list(4)-list of sessionTypes
     * List for Register Client - List(0)- Action, list(1) -person
     * list for Unregister Client - list(0)- Action, list(1)- Client
     * list for Add Session - list(0)- Action, list(1)- SessionType, list(2)- String date, list(3)- ForumType,
     *                        list(4)- Instructor
     * list for Register Client to Lesson - list(0)-Action, list(1)-Session, list(2)- Client
     * @param objectsList- in order that is always the same
     */
    protected static void createActions(List <Object> objectsList) {

    }
}
