package gym.management.Sessions;
/**
 * A class for Ninja type of lesson
 */
public class Ninja extends Session {
    private int price=150;
    private int capacity=5;
    /**
     * A regular constructor that forward all the fields
     * @param date the date that the session is happened
     * @param forumType the forum type of the session
     * @param instructor the instructor that coach the lesson
     */
    protected Ninja(String date, ForumType forumType, Instructor instructor) {
        super(date, forumType, instructor);
    }
    ///////////////// Getters //////////////////
    public int getPrice() {
        return price;
    }
    public int getCapacity() {
        return capacity;
    }
}
