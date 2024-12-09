package gym.management.Sessions;

import gym.Actions;
import gym.Exception.InstructorNotQualifiedException;

/**
 * This class charge on creating Sessions.
 */
public class CreateSession {
    /**
     * This method check if the action requirement is really to create new instructor, if it does it create it
     * @param a- the action we want to make
     * @param sessionType- Type of the session
     * @param time - the date of the class
     * @param forumType - forum tipe of the class
     * @param instructor - the instructor that do the session
     * @return - the session we created.
     */
    public static Session do_action(Actions a, SessionType sessionType, String time,
                                    ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {
        if(a==Actions.addSession) {
            if (!instructor.getSessionTypes().contains(sessionType)) {
                throw new InstructorNotQualifiedException();
            }
            return new Session(sessionType, time, forumType, instructor);
        }
        return null;
    }
}
