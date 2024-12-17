package gym.management;

import gym.customers.Person;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

public class Instructor extends Person {

    private Person p;
    private int salary;
    private ArrayList<SessionType> qual;

    public Instructor(Person p, int salary, ArrayList<SessionType>qualifications){
        super(p.getName(), p.getBalance(), p.getGender(), p.getDoB());
        this.p = p;
        this.salary = salary;
        this.qual = qualifications;
    }
    public ArrayList<SessionType> getQualifications(){
        return qual;
    }


    public void getId() {

    }
}
