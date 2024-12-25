package gym.management.Sessions;

import java.text.ParseException;
import java.time.format.DateTimeParseException;

/**
 * A class for Thai Boxing type of lesson
 */
public class ThaiBoxing extends Session {
    /**
     * A regular constructor that forward all the fields
     *
     * @param date       the date that the session is happened
     * @param forumType  the forum type of the session
     * @param instructor the instructor that coach the lesson
     */
    protected ThaiBoxing(String date, ForumType forumType, Instructor instructor) throws DateTimeParseException {
        super(date, forumType, instructor,100,20);
    }
}
