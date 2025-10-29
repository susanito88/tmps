package lab0;

public class Main {
    public static void notifyUser(Notification notification, String message){
        notification.send(message);  // any subclass
    }

    public static void main(String[] args){

        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.listBooks();

        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        notifyUser(email, "New book added!");
        notifyUser(sms, "New book added!");
    }
}

