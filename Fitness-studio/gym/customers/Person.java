package gym.customers;

import gym.management.Gender;
import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String name;
    private String dOb;
    private Gender gender;
    private int balance;
    private String notifications;
    private static int idCounter= 1111;
    private final int id;

    public Person(String name,int balance, Gender gender, String dOb) {
        this.name = name;
        this.gender = gender;
        this.dOb = dOb;
        this.balance = balance;
        this.id = idCounter++;
    }

    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public String getDoB() {
        return dOb;
    }
    public int getBalance(){
        return balance;
    }

    public String getNotifications() {
        return notifications;
    }
    public double getAge(){
            try {
                // Define the formatter for the date of birth string
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                // Parse the dOb string to a LocalDate
                LocalDate birthDate = LocalDate.parse(dOb, formatter);

                // Calculate the period between birth date and current date
                Period period = Period.between(birthDate, LocalDate.now());

                // Calculate the age in years as a double
                int years = period.getYears();
                int months = period.getMonths();
                int days = period.getDays();

                // Approximate months and days into a fraction of the year
                double age = years + (months / 12.0) + (days / 365.0);

                return age;
            } catch (DateTimeParseException e) {
                // Handle parse exceptions
                System.err.println("Invalid date format for dOb: " + dOb);
                return -1; // or handle appropriately
            }
        }
    public String toString() {
        return "ID: " + id + "|" +
                "Name: " + name + "|" +
                "Gender: " + gender + "|" +
                "Birthday: " + dOb + "|" +
                "Balance: " + balance;
    }

    }

