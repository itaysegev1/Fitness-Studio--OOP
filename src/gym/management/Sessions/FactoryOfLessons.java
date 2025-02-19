package gym.management.Sessions;

import gym.Actions;
import gym.Exception.InstructorNotQualifiedException;

import java.time.format.DateTimeParseException;

public class FactoryOfLessons {
    /**
     * This method is responsible for creating new sessions, this is a FACTORY of sessions,
     * for each type of lesson we build a match object.
     *
     * @param sessionType    type of the session need to be created
     * @param time           the date of the session
     * @param forumType      the forum type for this session
     * @param instructor     the instructor that instruct
     * @param create_session
     * @return the session that have been created
     * @throws InstructorNotQualifiedException if the instructor not qualified to coach this session
     */
    public static Session createSession(SessionType sessionType, String time, ForumType forumType, Instructor instructor,
                                        Actions action) throws InstructorNotQualifiedException, DateTimeParseException {
        if(action!=Actions.create_session)
            return null;
        if (!instructor.getSessionTypes().contains(sessionType)) {
            throw new InstructorNotQualifiedException("Error: Instructor is not qualified to conduct this session type.");
        }
        switch (sessionType) {
            case Ninja:
                return new Ninja(time, forumType, instructor);
            case Pilates:
                return new Pilates(time, forumType, instructor);
            case ThaiBoxing:
                return new ThaiBoxing(time, forumType, instructor);
            case MachinePilates:
                return new MachinePilates(time, forumType, instructor);
        }
        return null;
    }
}
