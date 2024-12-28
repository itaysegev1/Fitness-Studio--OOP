
import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;
import gym.customers.Client;
import gym.customers.Gender;
import gym.customers.Person;
import gym.management.Gym;
import gym.management.Secretary;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Instructor;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.*;

/**
 * This Class created by: Itay Segev.
 * The Interactive_Main class simulates the operations of a gym, allowing the secretary to register clients, hire instructors,
 * manage sessions, and notify clients of important events. The system involves creating people, clients, instructors,
 * and sessions and performing various operations like registration, removal, and notifications.
 */
public class Interactive_Main {
    public static void main(String[] args) throws InvalidAgeException, DuplicateClientException, InstructorNotQualifiedException {
        Scanner scanner = new Scanner(System.in);
        List<Secretary> secretaries = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Session> sessions = new ArrayList<>();
        List<Instructor> instructors = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        Gym gym = Gym.getInstance();
        startall(gym, sessions, people, instructors, clients);
        gym.setName("CrossFit");
        Secretary sec = gym.getSecretary();
        secretaries.add(sec);
        boolean flag = true;
        while (flag) {
            System.out.println("\nchoose a action to do:");
            System.out.println("\t1. Add person");
            System.out.println("\t2. Register client");
            System.out.println("\t3. Unregistered client");
            System.out.println("\t4. Hire instructor");
            System.out.println("\t5. Add session");
            System.out.println("\t6. Register client to session");
            System.out.println("\t7. Notify to all clients");
            System.out.println("\t8. Notify to clients in a specific session");
            System.out.println("\t9. Notify to clients in a specific date");
            System.out.println("\t10.Print all actions");
            System.out.println("\t11.Set a new new secretary");
            System.out.println("\t12.choose from the secretary history list");
            System.out.println("\t13.Print gym information");
            System.out.println("\t14.Pay Salaries to all employes");
            System.out.println("\t0. Exit");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("you chose to add person");
                    Person p = createp();
                    if (p != null)
                        people.add(p);
                    System.out.println("this person added successfully");
                    break;
                case 2:
                    System.out.println("you chose to register client");
                    Client c = null;
                    try {
                        c = createclient(people, sec);

                    } catch (InvalidAgeException e) {
                        System.out.println(e.getMessage());
                    } catch (DuplicateClientException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    if (c != null) {
                        clients.add(c);
                        System.out.println("The client added successfully");
                    }
                    break;
                case 3:
                    System.out.println("you chose to remove client");
                    try {
                        removeClient(clients, sec);
                        System.out.println("The client removed successfully");
                    } catch (ClientNotRegisteredException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    break;
                case 4:
                    System.out.println("you chose to hire instructor");
                    try {
                        instructors.add(hireinstructor(instructors, people, sec));
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    System.out.println("This Instructor added successfully");
                    break;
                case 5:
                    System.out.println("you chose to add session");
                    Session session = null;
                    try {
                        session = addsession(instructors, sec);

                    } catch (InstructorNotQualifiedException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    if (session != null) {
                        sessions.add(session);
                        System.out.println("The session added successfully");
                    }
                    break;
                case 6:
                    System.out.println("you chose to register client to session");
                    try {
                        register_client_to_session(sessions, clients, sec);
                    } catch (DuplicateClientException e) {
                        System.out.println(e.getMessage());
                    } catch (ClientNotRegisteredException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    break;
                case 7:
                    System.out.println("you chose to notify to all clients");
                    try {
                        notifyall(sec);
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    break;
                case 8:
                    System.out.println("you chose to notify to clients in a specific session");
                    try {
                        notifydate(sec);
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    break;
                case 9:
                    System.out.println("you chose to notify to clients in a specific date");
                    try {
                        notifysession(sec, sessions);
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    break;
                case 10:
                    System.out.println("You chose to print all the action history");
                    try {
                        sec.printActions();
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    break;
                case 11:
                    System.out.println("you chose to set a new secretary");
                    secretaries.add(setsec(people, gym));
                    sec = gym.getSecretary();
                    break;
                case 12:
                    System.out.println("you chose to choose another secretary");
                    sec = choosesec(secretaries);
                    break;
                case 13:
                    System.out.println(gym);
                    break;
                case 14:
                    try {
                        sec.paySalaries();
                    } catch (NullPointerException e) {
                        System.out.println("Error: Former secretaries are not permitted to perform actions");
                    }
                    break;
                case 0:
                    flag = false;
                    break;
            }

        }
    }

    /**
     * Creates a new Person instance based on user input.
     * Prompts the user for a decision to create a person, then collects the necessary details such as
     * name, balance, gender, and birthdate. If gender is chosen as Male, a Person instance with Gender.Male
     * is returned; otherwise, a Person instance with Gender.Female is returned.
     * If the user decides not to create a person, the method returns null.
     *
     * @return a newly created Person instance or null if the creation process is declined by the user.
     */
    public static Person createp() {
        System.out.println("you creating a new person \n if you dont want to press 0 otherwise press 1");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1) {
            scanner.nextLine();
            System.out.println("enter persons name :");
            String name = scanner.nextLine();
            System.out.println("enter persons balance :");
            int balance = scanner.nextInt();
            System.out.println("choose persons gender :");
            System.out.println("\t 1.Male \n\t2.Female");
            int gender = scanner.nextInt();
            scanner.nextLine();
            System.out.println("choose persons Birthdate need to be : dd-MM-yyyy");
            String birthdate = scanner.nextLine();
            System.out.println("creating....");
            if (gender == 1) {
                System.out.println("finished creating person");
                return new Person(name, balance, Gender.Male, birthdate);
            }
            System.out.println("finished creating person");
            return new Person(name, balance, Gender.Female, birthdate);
        }
        return null;
    }

    /**
     * Creates a new Client instance by selecting a Person from a list and registering them through a Secretary.
     * The method prompts the user to select a person from the provided list of people and uses the Secretary
     * to register the chosen person as a Client.
     *
     * @param people a list of Person objects to select from
     * @param sec    the Secretary responsible for registering the Person as a Client
     * @return a newly created Client instance if successful, or null if the input is invalid
     * @throws InvalidAgeException      if the selected person's age is invalid for client registration
     * @throws DuplicateClientException if the selected person is already registered as a client
     */
    public static Client createclient(List<Person> people, Secretary sec) throws InvalidAgeException, DuplicateClientException {
        System.out.println("choose the person you want to create from");
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) != null) {
                System.out.println("\t" + (i + 1) + ". " + people.get(i));
            } else
                System.out.println("\t" + (i + 1) + ". null");

        }
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= people.size() && number > 0) {
            return sec.registerClient(people.get(number - 1));
        }
        return null;
    }

    /**
     * Removes a client from the gym by unregistering them through the provided Secretary.
     * Prompts the user to select a client from the provided list of clients for removal.
     *
     * @param clients a list of Client objects representing the clients currently registered
     * @param sec     the Secretary responsible for handling the client unregistration
     * @throws ClientNotRegisteredException if the chosen client is not registered in the system
     */
    public static void removeClient(List<Client> clients, Secretary sec) throws ClientNotRegisteredException {
        System.out.println("choose the client you want to remove");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + clients.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= clients.size() && number > 0)
            sec.unregisterClient(clients.get(number - 1));
    }

    /**
     * Hires an instructor based on user input, allowing the user to select a person from a list,
     * specify a salary, and choose the instructor's certified session types.
     * The hiring process is facilitated by the provided Secretary.
     *
     * @param instructors a list of existing Instructor objects for reference
     * @param people      a list of Person objects to choose from for creating the Instructor
     * @param sec         the Secretary responsible for hiring and managing instructors
     * @return a newly created Instructor instance if the process is successful, or null if the input is invalid
     */
    public static Instructor hireinstructor(List<Instructor> instructors, List<Person> people, Secretary sec) {
        System.out.println("choose the person you want to create from");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + people.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Enter the salary per hour: ");
        int salary = scanner.nextInt();
        boolean flag = true;
        System.out.println("choose all the sessions type for this instructor");
        List<SessionType> sessionTypes = new ArrayList<>();
        while (flag) {
            System.out.println("choose from this list: \n\t1." + SessionType.Ninja + "\n\t2." + SessionType.Pilates
                    + "\n\t3." + SessionType.ThaiBoxing + "\n\t4." + SessionType.MachinePilates);
            switch (scanner.nextInt()) {
                case 1:
                    sessionTypes.add(SessionType.Ninja);
                    break;
                case 2:
                    sessionTypes.add(SessionType.Pilates);
                    break;
                case 3:
                    sessionTypes.add(SessionType.ThaiBoxing);
                    break;
                case 4:
                    sessionTypes.add(SessionType.MachinePilates);
                    break;
            }
            System.out.println("if you want to add another one press 1 otherwise press 0");
            if (scanner.nextInt() == 0) {
                flag = false;
            }
        }

        if (number <= people.size() && number > 0) {
            return sec.hireInstructor(people.get(number - 1), salary, sessionTypes);
        }
        return null;
    }

    /**
     * Adds a new session to the gym. The method prompts the user to select a session type,
     * an instructor, a forum type, and to provide a date and time for the session. The session
     * is created and added using the specified Secretary instance.
     *
     * @param instructors a list of available instructors to choose from for the session
     * @param sec         the Secretary responsible for adding the session
     * @return the created Session object if successfully added, or null if any required input is invalid
     * @throws InstructorNotQualifiedException if the selected instructor is not qualified for the chosen session type
     */
    public static Session addsession(List<Instructor> instructors, Secretary sec) throws InstructorNotQualifiedException {
        System.out.println("choose the session you want to add");
        System.out.println("choose from this list: \n\t1." + SessionType.Ninja + "\n\t2." + SessionType.Pilates
                + "\n\t3." + SessionType.ThaiBoxing + "\n\t4." + SessionType.MachinePilates);
        Scanner scanner = new Scanner(System.in);
        SessionType sessionType = null;
        switch (scanner.nextInt()) {
            case 1:
                sessionType = SessionType.Ninja;
                break;
            case 2:
                sessionType = SessionType.Pilates;
                break;
            case 3:
                sessionType = SessionType.ThaiBoxing;
                break;
            case 4:
                sessionType = SessionType.MachinePilates;
                break;
        }
        System.out.println("choose an instructor from this list: ");
        for (int i = 0; i < instructors.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + instructors.get(i));
        }
        int number = scanner.nextInt();
        Instructor instructor = null;
        if (number <= instructors.size() && number > 0) {
            instructor = instructors.get(number - 1);
        }
        System.out.println("Select forum type: ");
        System.out.println("\t1." + ForumType.All + "\n\t2." + ForumType.Seniors + "\n\t3." + ForumType.Female + "\n\t4." + ForumType.Male);
        ForumType forumType = null;
        switch (scanner.nextInt()) {
            case 1:
                forumType = ForumType.All;
                break;
            case 2:
                forumType = ForumType.Seniors;
                break;
            case 3:
                forumType = ForumType.Female;
                break;
            case 4:
                forumType = ForumType.Male;
                break;
        }
        scanner.nextLine();
        String date = null;
        System.out.println("enter the date and hour of the session: need to be dd-MM-yyyy HH:mm");
        date = scanner.nextLine();
        Session session = null;
        if (instructor != null && forumType != null && sessionType != null) {
            session = sec.addSession(sessionType, date, forumType, instructor);
        }
        return session;
    }

    /**
     * Registers a client to a specified session through the provided Secretary.
     * The method prompts the user to choose a session and a client from the respective lists
     * and executes the registration process.
     *
     * @param sessions a list of Session objects representing the available sessions
     * @param clients  a list of Client objects representing the available clients
     * @param sec      the Secretary managing the registration process
     * @return true if the registration process is completed successfully
     * @throws DuplicateClientException     if the client is already registered in the chosen session
     * @throws ClientNotRegisteredException if the client is not registered in the system
     */
    public static boolean register_client_to_session(List<Session> sessions, List<Client> clients, Secretary sec)
            throws DuplicateClientException, ClientNotRegisteredException {
        System.out.println("choose the session you want");
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + sessions.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Session session = null;
        if (number <= sessions.size() && number > 0) {
            session = sessions.get(number - 1);
        }
        System.out.println("choose a client from this list to register this session: ");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + clients.get(i));
        }
        number = scanner.nextInt();
        Client client = null;
        if (number <= clients.size() && number > 0) {
            client = clients.get(number - 1);
        }
        sec.registerClientToLesson(client, session);
        return true;
    }

    /**
     * Prompts the user to enter a message and notifies all clients of the gym using the provided Secretary instance.
     *
     * @param sec the Secretary responsible for sending notifications to all clients
     */
    public static void notifyall(Secretary sec) {
        System.out.println("Please enter the messege you want to notify: ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        sec.notify(message);
    }

    /**
     * Prompts the user to enter a message and a date, then notifies all clients
     * who are registered for sessions on the specified date using the provided Secretary instance.
     *
     * @param sec the Secretary responsible for sending notifications to the clients
     */
    public static void notifydate(Secretary sec) {
        System.out.println("Please enter the messege you want to notify: ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println("please enter the date you want to notify: dd-MM-yyyy");
        String date = scanner.nextLine();
        sec.notify(message, date);
    }

    /**
     * Prompts the user to enter a message and select a session from the provided list of sessions.
     * The selected session is then notified with the specified message by utilizing the provided Secretary instance.
     *
     * @param sec      the Secretary responsible for sending the notification to the selected session
     * @param sessions a list of Session objects representing the available sessions for notification
     */
    public static void notifysession(Secretary sec, List<Session> sessions) {
        System.out.println("Please enter the messege you want to notify: ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println("please choose the session you want to notify: ");
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + sessions.get(i));
        }
        int number = scanner.nextInt();
        Session session = null;
        if (number <= sessions.size() && number > 0) {
            session = sessions.get(number - 1);
        }
        sec.notify(session, message);
    }

    /**
     * Initializes the gym environment by adding people, clients, instructors,
     * and sessions to their respective lists and setting up relationships between them.
     *
     * @param gym         The gym to be initialized with a secretary, clients, and instructors.
     * @param sessions    The list of sessions to be populated with new sessions.
     * @param people      The list of people to be populated with new individuals including clients and instructors.
     * @param instructors The list of instructors to be populated with hired instructors.
     * @param clients     The list of clients to be populated with registered clients.
     * @throws InvalidAgeException             If any person is of an invalid age for the operations being performed.
     * @throws DuplicateClientException        If an attempt to register a duplicate client is made.
     * @throws InstructorNotQualifiedException If an instructor hired lacks qualifications for specific session types.
     */
    public static void startall(Gym gym, List<Session> sessions, List<Person> people, List<Instructor> instructors, List<Client> clients) throws InvalidAgeException, DuplicateClientException, InstructorNotQualifiedException {

        Person p1 = new Person("David", 500, Gender.Male, "20-02-1978");
        Person p2 = new Person("Nofar", 1200, Gender.Female, "03-07-1998");
        Person p3 = new Person("Maayan", 200, Gender.Female, "21-12-2004");
        Person p4 = new Person("Shachar", 300, Gender.Female, "09-04-1958");
        Person p5 = new Person("Yuval", 650, Gender.Female, "23-05-1976");
        Person p6 = new Person("Noam", 70, Gender.Male, "20-12-1984");
        Person p7 = new Person("Neta", 600, Gender.Male, "12-02-1993");
        Person p8 = new Person("Rom", 1600, Gender.Female, "12-12-1999");
        gym.setSecretary(p1, 9000);
        Secretary sec = gym.getSecretary();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);
        people.add(p7);
        people.add(p8);
        Client c1 = sec.registerClient(p2);
        Client c2 = sec.registerClient(p3);
        Client c3 = sec.registerClient(p4);
        Client c4 = sec.registerClient(p5);
        Client c5 = sec.registerClient(p6);
        Client c6 = sec.registerClient(p7);
        Client c7 = sec.registerClient(p8);
        Instructor i1 = sec.hireInstructor(p4, 70, new ArrayList<>(Arrays.asList(SessionType.ThaiBoxing, SessionType.MachinePilates)));
        Instructor i2 = sec.hireInstructor(p5, 90, new ArrayList<>(Arrays.asList(SessionType.ThaiBoxing, SessionType.Pilates, SessionType.MachinePilates)));
        Instructor i3 = sec.hireInstructor(p6, 50, new ArrayList<>(Arrays.asList(SessionType.Pilates, SessionType.Ninja)));

        Session s1 = sec.addSession(SessionType.Pilates, "23-01-2025 10:00", ForumType.All, i2);
        Session s2 = sec.addSession(SessionType.MachinePilates, "23-10-2024 08:00", ForumType.Female, i1);
        Session s3 = sec.addSession(SessionType.Pilates, "25-01-2025 09:30", ForumType.Seniors, i3);
        Session s4 = sec.addSession(SessionType.ThaiBoxing, "01-01-2025 14:00", ForumType.All, i2);
        Session s5 = sec.addSession(SessionType.Ninja, "14-01-2025 20:00", ForumType.All, i3);
        Session s6 = sec.addSession(SessionType.ThaiBoxing, "14-01-2025 20:00", ForumType.Male, i1);
        clients.add(c1);
        clients.add(c2);
        clients.add(c3);
        clients.add(c4);
        clients.add(c5);
        clients.add(c6);
        clients.add(c7);
        instructors.add(i1);
        instructors.add(i2);
        instructors.add(i3);
        sessions.add(s1);
        sessions.add(s2);
        sessions.add(s3);
        sessions.add(s4);
        sessions.add(s5);
        sessions.add(s6);
    }

    /**
     * Sets
     */
    public static Secretary setsec(List<Person> people, Gym gym) {
        System.out.println("choose the person you want to create from");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + people.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Person p = null;
        if (number <= people.size() && number > 0) {
            p = people.get(number - 1);
        }
        System.out.println("Choose salary per month: ");
        int salary = scanner.nextInt();
        gym.setSecretary(p, salary);
        return gym.getSecretary();
    }

    /**
     * Allows the user to choose a Secretary from a given list by displaying options
     * and reading the user's input. If the input is valid, the selected Secretary
     * is returned. If the input is invalid, the last Secretary in the list is returned.
     *
     * @param secretaries a list of Secretary objects to choose from
     * @return the selected Secretary if the input is valid; otherwise, the last Secretary in the list
     */
    public static Secretary choosesec(List<Secretary> secretaries) {
        System.out.println("choose the number of the secretary you want");
        for (int i = 0; i < secretaries.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + secretaries.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= secretaries.size() && number > 0) {
            return secretaries.get(number - 1);
        }
        return secretaries.getLast();
    }

}
