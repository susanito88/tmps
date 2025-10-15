package lab0;

public class Main {
    public static void notifyUser(Notification notification, String message){
        notification.send(message);  // Works for any subclass of Notification
    }

    public static void main(String[] args){
        // Library example
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.listBooks();

        // Notifications
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        notifyUser(email, "New book added!");
        notifyUser(sms, "New book added!");
    }
}

