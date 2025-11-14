package lab2.decorator;

public class EmailDecorator extends NotifierDecorator {
    public EmailDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void notify(String to, String message) {
        super.notify(to, message);
        sendEmail(to, message);
    }

    private void sendEmail(String email, String message) {
        System.out.println("[Email] Sending email to " + email + ": " + message);
    }
}
