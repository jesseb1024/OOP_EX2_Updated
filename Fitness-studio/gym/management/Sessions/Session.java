package gym.management.Sessions;

import gym.customers.Client;
import gym.management.ForumType;
import gym.management.Instructor;

import java.util.ArrayList;

public class Session {
    private String time;
    private Instructor instructor;
    private ForumType forumType;
    private ArrayList<Client> participants;
    private SessionType sessionType;

    public Session(String time, ForumType forumType, Instructor instructor) {
        this.time = time;
        this.forumType = forumType;
        this.instructor = instructor;
        this.participants = new ArrayList<>();
    }


    public boolean isParticipant(Client client) {
        return participants.contains(client);
    }

    public Instructor getInstructor() {
        return this.instructor;
    }


    public void addParticipant(Client client) {
        if (!participants.contains(client)) {
            participants.add(client);
        } else {
            System.out.println("Client is already registered for this session.");
        }
    }
}
