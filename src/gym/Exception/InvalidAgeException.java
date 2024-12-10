package gym.Exception;

public class InvalidAgeException extends Throwable{
    /**
     * This Exception references to a client that try to register to gym and not yet 18 years old
     * @return  a message of the exception
     */
    @Override
    public String getMessage() {
        return "Error: Client must be at least 18 years old to register";
    }
}
