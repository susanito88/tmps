package lab0;

public class SMSNotification extends Notification {
    @Override
    public void send(String message){
        System.out.println("Sending SMS: " + message);
    }
}
