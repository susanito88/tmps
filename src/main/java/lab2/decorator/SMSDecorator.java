package lab2.decorator;

public class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void notify(String to, String message) {
        super.notify(to, message);
        sendSMS(to, message);
    }

    private void sendSMS(String phone, String message) {
        System.out.println("[SMS] Sending SMS to " + phone + ": " + message);
    }
}
