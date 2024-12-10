package gym.Exception;

public class InstructorNotQualifiedException extends Throwable{
    /**
     * This Exception references to an instructor that not qualified for a session type
     * @return  a message of the exception
     */
    @Override
    public String getMessage() {
        return "Error: Instructor is not qualified to conduct this session type.";
    }
}
