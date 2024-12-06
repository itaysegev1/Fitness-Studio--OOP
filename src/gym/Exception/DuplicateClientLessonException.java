package gym.Exception;

public class DuplicateClientLessonException extends DuplicateClientException{
    @Override
    public String getMessage() {
        return "Error: The client is already registered for this lesson";
    }
}
