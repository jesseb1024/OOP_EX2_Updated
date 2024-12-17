package gym.customers;
import gym.management.Gender;
import gym.management.Instructor;
import gym.management.Secretary;
import java.util.ArrayList;

public class PersonFactory {
    public static Person createPerson(String type, String name, String dOb, Gender gender, int salary,int balance, ArrayList qualifications, Person p) {
        switch (type.toLowerCase()) {
            case "secretary":
                return new Secretary(p, salary);
            case "instructor":
                return new Instructor(p, salary, qualifications);
            case "client":
                return new Client(p);
            case "person":
            default:
                return new Person(name, balance, gender, dOb);
        }

        }
    }
