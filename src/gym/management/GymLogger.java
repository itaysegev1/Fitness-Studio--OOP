package gym.management;

import java.util.ArrayList;
import java.util.List;

public class GymLogger {
    private static GymLogger logger=new GymLogger();
   private List<String>log;

    private GymLogger() {
        log=new ArrayList<>();
    }
    protected static GymLogger getInstance() {
        return logger;
    }
    protected void log(String msg) {
        this.log.add(msg);
    }
    protected String log() {
        String result="";
        for(String msg:log) {
            result+=msg+"\n";
        }
        return result;
    }
    protected void printLog(){
        for(String msg:log) {
            System.out.println(msg);
        }
    }
}
