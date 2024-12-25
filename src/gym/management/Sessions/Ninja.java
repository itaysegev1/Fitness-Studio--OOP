package gym.management.Sessions;

import java.time.format.DateTimeParseException;

/**
 * A class for Ninja type of lesson
 */
public class Ninja extends Session {
    /**
     * A regular constructor that forward all the fields
     *
     * @param date       the date that the session is happened
     * @param forumType  the forum type of the session
     * @param instructor the instructor that coach the lesson
     */
    protected Ninja(String date, ForumType forumType, Instructor instructor) throws DateTimeParseException {
        super(date, forumType, instructor,150,5);
    }
}
