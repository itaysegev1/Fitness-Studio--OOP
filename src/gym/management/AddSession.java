package gym.management;

import gym.Actions;
import gym.Exception.InstructorNotQualifiedException;
import gym.management.Sessions.*;

class AddSession {
    protected static Session Do(SessionType sessionType, String time,
                                ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException{
        Session s= FactoryOfLessons.createSession(sessionType, time, forumType, instructor);
        Gym gym=Gym.getInstance();
        if(!gym.IsContainSession(s)){
            gym.addSession(s);
            GymLogger.getInstance().log("Created new session: "+s.getSessionType()+" on "+s.getDate()+
                    " with instructor: "+s.getInstructor().getName());
            return s;
        }
        return null;

    }
}
