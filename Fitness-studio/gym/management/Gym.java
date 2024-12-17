package gym.management;

import gym.customers.Client;
import gym.customers.Notifications;
import gym.customers.Person;
import gym.management.Sessions.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gym {
    private static Gym instance;
    private Gym() {
        _name ="";
        _balance = 0;
        _clients = new ArrayList<>();
        _sessions = new ArrayList<>();
        _instructors = new ArrayList<>();
        _dateToClientMap = new HashMap<>();
        _actions = new ArrayList<>();
        _last_id = 1111;
        _counter_session = new HashMap<>();
    }

    private int _last_id;
    private String _name;
    private int _balance;
    private ArrayList<Client> _clients;
    private ArrayList<Session> _sessions;
    private ArrayList<Instructor> _instructors;
    private Map<String, ArrayList<Notifications>> _dateToClientMap;
    private HashMap<Instructor,Integer> _counter_session;
    private ArrayList<String> _actions;
    private Secretary _secretary;

    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    public void setSecretary(Person p, int salary){
        _actions.add("A new secretary has started working at the gym: " + p.getName());
        _secretary = new Secretary(p, salary);
    }
    public Secretary getSecretary(){
        return _secretary;
    }
    public void setName(String name){
        _name = name;
    }

    @Override
    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gym.management.Gym Name: ").append(_name).append("\n");
        sb.append("gym.management.Gym ").append(_secretary).append("\n");
        sb.append("gym.management.Gym Balance: ").append(_balance).append("\n\n");

        sb.append("Clients Data:\n");
        for (Client client : _clients) {
            sb.append(client).append("\n");
        }

        sb.append("\nEmployees Data:\n");
        for (Instructor employee : _instructors) {
            sb.append(employee).append("\n");
        }
        sb.append(_secretary).append("\n");

        sb.append("\nSessions Data:\n");
        for (Session session : _sessions) {
            sb.append(session).append("\n");
        }

        return sb.toString();
    }
}