package gym.Exception;

public class DuplicateClientGymException extends DuplicateClientException{
    @Override
    public String getMessage() {
        return "Error: The client is already registered";
    }
}
