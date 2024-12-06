package gym.Exception;

public class ClientNotRegisteredToGymException extends  ClientNotRegisteredException{
    @Override
    public String getMessage(){
        return "Error: Registration is required before attempting to unregister";
    }
}
