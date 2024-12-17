package gym.management.Sessions;

public abstract class SessionType{
    private String name;
    private int capacity;
    private int price;

    public static SessionType Ninja = new Ninja();
    public static SessionType Pilates = new Pilates();
    public static SessionType MachinePilates= new MachinePilates();
    public static SessionType ThaiBoxing = new ThaiBoxing();

    public SessionType(String name, int capacity, int price){
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getPrice(){
        return price;
    }
}
