package gym.Exception;

public class DuplicateClientLessonException extends DuplicateClientException{
    /**
     * This Exception references to a client that try to register to lesson, but already registered to.
     * @return  a message of the exception
     */
    @Override
    public String getMessage() {
        return "Error: The client is already registered for this lesson";
    }
}
