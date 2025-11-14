package lab2.decorator;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;

    protected NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void notify(String to, String message) {
        wrappee.notify(to, message);
    }
}
