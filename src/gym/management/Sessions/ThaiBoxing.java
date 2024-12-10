package gym.management.Sessions;

public class ThaiBoxing extends Session {
    private int price=100;
    private int capacity=20;
    protected ThaiBoxing(String date, ForumType forumType, Instructor instructor) {
        super(date, forumType, instructor);
    }
    public int getPrice() {
        return price;
    }
    public int getCapacity() {
        return capacity;
    }
}
