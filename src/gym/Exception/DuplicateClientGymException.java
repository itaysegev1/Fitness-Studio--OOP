package gym.Exception;

public class DuplicateClientGymException extends DuplicateClientException{
    /**
     * This Exception references to a client that try to register to the gym, but already registered.
     * @return a message of the exception
     */
    @Override
    public String getMessage() {
        return "Error: The client is already registered";
    }
}
