package gym.management;

import gym.customers.Person;

public class Secretary extends Person {
    int salary;
    public Secretary(Person person,int salary) {
        super(person);
        this.salary = salary;
    }
}
