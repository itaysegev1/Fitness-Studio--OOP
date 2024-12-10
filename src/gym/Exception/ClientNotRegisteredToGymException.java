package gym.Exception;

public class ClientNotRegisteredToGymException extends  ClientNotRegisteredException{
    /**
     * This Exception references to a client that try to unregister from the gym, but not registered to.
     * @return  a message of the exception
     */
    @Override
    public String getMessage(){
        return "Error: Registration is required before attempting to unregister";
    }
}
