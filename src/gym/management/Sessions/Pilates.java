package gym.management.Sessions;

public class Pilates extends Session {
    private int price=60;
    private int capacity=30;
    protected Pilates(SessionType sessionType, String date, ForumType forumType, Instructor instructor) {
        super(sessionType, date, forumType, instructor);
    }
    public int getPrice() {
        return price;
    }
    public int getCapacity() {
        return capacity;
    }
}
