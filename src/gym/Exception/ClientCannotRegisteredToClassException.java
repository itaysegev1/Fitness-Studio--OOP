package gym.Exception;

public class ClientCannotRegisteredToClassException extends ClientNotRegisteredException {

    @Override
    public String getMessage() {
      return "Error: The client is not registered with the gym and cannot enroll in lessons";
    }
}
