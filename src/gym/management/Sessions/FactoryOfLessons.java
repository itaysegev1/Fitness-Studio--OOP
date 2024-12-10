package gym.management.Sessions;

import gym.Exception.InstructorNotQualifiedException;

public class FactoryOfLessons {

    public static Session createSession(SessionType sessionType, String time, ForumType forumType, Instructor instructor)
            throws InstructorNotQualifiedException {

        if (!instructor.getSessionTypes().contains(sessionType)) {
            throw new InstructorNotQualifiedException();
        }

        if(sessionType.equals(SessionType.Ninja))
            return new Ninja(time, forumType, instructor);
        if (sessionType.equals(SessionType.Pilates))
            return new Pilates( time, forumType, instructor);
        if(sessionType.equals(SessionType.ThaiBoxing))
            return new ThaiBoxing(time, forumType, instructor);
        if(sessionType.equals(SessionType.MachinePilates))
            return new MachinePilates(time, forumType, instructor);
        return null;
    }
}
