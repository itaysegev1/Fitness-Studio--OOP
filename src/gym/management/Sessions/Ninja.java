package gym.management.Sessions;

public class Ninja extends Session {
    private int price=150;
    private int capacity=5;
    protected Ninja(String date, ForumType forumType, Instructor instructor) {
        super(date, forumType, instructor);
    }
    public int getPrice() {
        return price;
    }
    public int getCapacity() {
        return capacity;
    }
}
