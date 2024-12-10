package gym.management.Sessions;

public class MachinePilates extends Session {
    private int price=80;
    private int capacity=10;
    protected MachinePilates(String date, ForumType forumType, Instructor instructor) {
        super(date, forumType, instructor);
    }
    public int getPrice() {
        return price;
    }
    public int getCapacity() {
        return capacity;
    }

}
