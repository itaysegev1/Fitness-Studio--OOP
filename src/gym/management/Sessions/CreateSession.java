package gym.management.Sessions;

import gym.Actions;
import gym.Exception.InstructorNotQualifiedException;

public class CreateSession {
    public static Session doaction(Actions a, SessionType sessionType, String time,
                                   ForumType forumType,Instructor instructor) throws InstructorNotQualifiedException {
        if(a==Actions.addSession) {
            if (!instructor.getSessionTypes().contains(sessionType)) {
                throw new InstructorNotQualifiedException();
            }
            return new Session(sessionType, time, forumType, instructor);
        }
        return null;
    }
}
