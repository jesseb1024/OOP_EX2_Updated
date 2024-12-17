package gym.management;
import gym.customers.Client;
import gym.customers.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;
import gym.management.exceptions.DuplicateClientException;
import gym.management.exceptions.InstructorNotQualifiedException;
import gym.management.exceptions.InvalidAgeException;

public class Secretary extends Person{
    private ArrayList<Instructor> instructors;
    private final ArrayList<String> actionsHistory;
    private ArrayList<Client> clients;
    private SessionType sessionType;
    private Client client;
    private Session session;
    private Instructor instructor;
    private String secMessage;
    private int salary;
    private final ArrayList<Session> sessions;

    public Secretary(Person person, int salary) {
        super(person.getName(), person.getBalance(), person.getGender(), person.getDoB()); // Call the Person constructor
        this.salary = salary;
        this.actionsHistory = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.instructors = new ArrayList<>();

    }

    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException {
        if (person.getAge() < 18) {
            throw new InvalidAgeException("Error: Client must be at least 18 years old to register.");
        }
        if (clients.stream().anyMatch(c -> c.equals(person))) {
            throw new DuplicateClientException("Error: The client is already registered.");
        }
        Client client = new Client(person);
        clients.add(client);
        logAction("Registered new client: " + person.getName());
        return client;
    }

    public void unregisterClient(Client client) {
        if (!clients.contains(client)) {
            System.out.println("Error: The client is not registered in the system");
            return; // Exit gracefully
        }

        logAction("Unregistered client: " + client.getName());
        clients.remove(client);
    }


    public Instructor hireInstructor(Person p, int salary, ArrayList<SessionType> sessionTypes) {
        this.instructor = new Instructor(p, salary, sessionTypes);
        instructors.add(instructor);
        logAction("Hired new instructor: " + instructor.getName());
        return instructor;
    }


    public void registerClientToLesson(Client client, Session session) {
        if (session.isParticipant(client)) {
            // Log the error instead of throwing an exception
            System.out.println("Error: The client is already registered for this session");
            return; // Exit the method gracefully
        }

        if (!clients.contains(client)) {
            // Log the error instead of throwing an exception
            System.out.println("Error: The client is not registered");
            return; // Exit the method gracefully
        }
        logAction("Registered client: " + client.getName() + "To session: " + session.toString());
        session.addParticipant(client);
    }

    public Session addSession(SessionType s, String time, ForumType a, Instructor i) throws InstructorNotQualifiedException {
        if(!i.getQualifications().contains(s)) {
            throw new InstructorNotQualifiedException("Error: Instructor is not qualified to conduct this session type.");
        }
        Session newSession = new Session(time, a, i); // Assuming you have a suitable constructor in Session
        sessions.add(newSession); // Add the session to the list
        return newSession;
    }
    public String notify(Session se, String st){
        this.session=se;
        this.secMessage=st;
        return secMessage;
    }
    public String notify(String date, String st){
        date = LocalDate.now().toString();
        this.secMessage=st;
        return secMessage;
    }

    public String notify(String s){
        this.secMessage=s;
        return secMessage;
    }

    public void logAction(String action) {
        actionsHistory.add(action);
    }

    public void paySalaries() {
        logAction("Salaries have been paid to all employees");
    }

    public void printActions() {
        System.out.println("---Actions history---");
        for (String action : actionsHistory) {
            System.out.println(action);
        }
    }

    }


