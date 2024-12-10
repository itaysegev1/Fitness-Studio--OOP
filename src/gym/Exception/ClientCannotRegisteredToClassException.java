package gym.Exception;

public class ClientCannotRegisteredToClassException extends ClientNotRegisteredException {

    /**
     * This Exception references to a client that try to register to lesson, but not registered to the gym
     * @return  a message of the exception
     */
    @Override
    public String getMessage() {
      return "Error: The client is not registered with the gym and cannot enroll in lessons";
    }
}
