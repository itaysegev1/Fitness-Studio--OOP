package gym.management.Sessions;

/**
 * A class for Machine Pilates type of lesson
 */
public class MachinePilates extends Session {
    private int price=80;
    private int capacity=10;

    /**
     * A regular constructor that forward all the fields
     * @param date - the date that the session is happened
     * @param forumType - the forum type of the session
     * @param instructor - the instructor that coach the lesson
     */
    protected MachinePilates(String date, ForumType forumType, Instructor instructor) {
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
