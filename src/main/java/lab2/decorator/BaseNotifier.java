package lab2.decorator;

public class BaseNotifier implements Notifier {
    @Override
    public void notify(String to, String message) {
        System.out.println("[BaseNotifier] Notify " + to + ": " + message);
    }
}
