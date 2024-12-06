package gym.Exception;

public class ClientNotRegisteredToClassException extends ClientNotRegisteredException {

    @Override
    public String getMessage() {
      return "The client is already registered for this lesson";
    }
}
