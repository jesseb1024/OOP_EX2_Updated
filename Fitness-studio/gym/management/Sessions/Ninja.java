package gym.management.Sessions;

public class Ninja extends SessionType{
    public Ninja() {
        super("Ninja", 5, 150);
    }
    @Override
    public String toString() {
        return "Ninja";
    }
}
