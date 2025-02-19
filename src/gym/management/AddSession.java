package gym.management;

import gym.Actions;
import gym.Exception.InstructorNotQualifiedException;
import gym.management.Sessions.*;
import java.time.format.DateTimeParseException;

/**
 * This class is charge on creating new sessions
 */
class AddSession {
    /**
     * This method charge on creating new sessions, by checking if the instructor can coach this session,
     * and it adds to the logger of the gym all the messages need to add
     * at the end if the lesson didn't exist in the gym it will create new one.
     *
     * @param sessionType -the type of the session we need to create
     * @param time        the date of the session
     * @param forumType   who can register to this session
     * @param instructor  the instructor that coach this session
     * @return the session that have been created
     * @throws InstructorNotQualifiedException if the instructor not qualified to coach this session
     */
    protected static Session Do(SessionType sessionType, String time,
                                ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {
        if (instructor != null) {
            try {
                Session s = FactoryOfLessons.createSession(sessionType, time, forumType, instructor, Actions.create_session);
                Gym gym = Gym.getInstance();
                if (!gym.IsContainSession(s)) {
                    gym.addSession(s);
                    GymLogger.getInstance().log("Created new session: " + s.getClass().getSimpleName() + " on " + s.getDate() +
                            " with instructor: " + s.getInstructor().getName());
                    instructor.addSession(s);
                    return s;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format for Session: " + time);
            }
        }
        return null;

    }
}
