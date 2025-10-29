# Lab 0 — SOLID Principles

**Author:** Alexandru Magla

---

## Objectives

This lab focuses on understanding and applying three core SOLID principles to create maintainable, extensible code:

- **S** — Single Responsibility Principle
- **O** — Open/Closed Principle
- **L** — Liskov Substitution Principle
- **I** — Interface Segregation Principle
- **D** — Dependency Inversion Principle

The implementation demonstrates these principles through a simple **Library Notification System** project, showcasing how SOLID principles make code easier to maintain and extend.

---

## Principles Applied

This project specifically implements three SOLID principles:

- **SRP (Single Responsibility Principle)** — Each class has one clear, well-defined responsibility
- **OCP (Open/Closed Principle)** — System behavior can be extended without modifying existing code
- **LSP (Liskov Substitution Principle)** — Subclasses can replace their parent types without breaking functionality

---

## Implementation Overview

The project simulates a **Library Notification System** where the library sends notifications when new books are added. Users can configure the notification type (Email, SMS, etc.) without modifying the core library logic.

### Project Structure

```
lab0/
├── Book.java
├── Library.java
├── Notification.java
├── EmailNotification.java
├── SMSNotification.java
├── Main.java
└── Report.md
```

---

## Principle Demonstrations

### 1. Single Responsibility Principle (SRP)

Each class in the system has a single, well-defined responsibility:

- **`Book`** — Stores and manages book details (title, author)
- **`Library`** — Manages the book collection and coordinates notifications
- **`EmailNotification` / `SMSNotification`** — Handle sending notifications through specific channels

#### Code Example

```java
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
```

```java
public class Library {
    private Notification notification;

    public Library(Notification notification) {
        this.notification = notification;
    }

    public void addBook(Book book) {
        System.out.println("Book added: " + book.getTitle());
        notification.send("A new book titled '" + book.getTitle() + "' was added to the library.");
    }
}
```

**Benefits:** By separating concerns, each class is easier to understand, test, and modify independently.

---

### 2. Open/Closed Principle (OCP)

The system is open for extension but closed for modification. New notification types can be added without changing existing code.

#### Code Example

```java
public interface Notification {
    void send(String message);
}
```

```java
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
```

```java
public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}
```

**Benefits:** Adding a new notification type (e.g., `PushNotification`, `SlackNotification`) requires only creating a new class that implements the `Notification` interface. The `Library` class remains unchanged.

---

### 3. Liskov Substitution Principle (LSP)

All implementations of the `Notification` interface can be used interchangeably without affecting program behavior. Any notification type can substitute another without breaking the system.

#### Code Example

```java
package lab0;

public class Main {
    public static void notifyUser(Notification notification, String message) {
        notification.send(message);  // Works seamlessly with any Notification implementation
    }

    public static void main(String[] args) {
        // Library operations
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.listBooks();

        // Notification examples
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        notifyUser(email, "New book added!");
        notifyUser(sms, "New book added!");
    }
}
```

#### Output Example

```
Added book: 1984
Added book: The Hobbit
Books in library:
- 1984 by George Orwell
- The Hobbit by J.R.R. Tolkien
Email sent: New book added!
SMS sent: New book added!
```

**Benefits:** The system treats all notification types uniformly, allowing flexible configuration and easy testing with mock implementations.

---

## Conclusion

This laboratory work successfully demonstrates the practical application of three fundamental SOLID principles in software design. Through the implementation of a Library Notification System, we achieved:

### Key Achievements

1. **Maintainability** — Each class has a clear, single purpose, making the codebase easier to understand and modify
2. **Extensibility** — New notification channels can be added without touching existing code, reducing the risk of introducing bugs
3. **Flexibility** — Different notification implementations can be swapped interchangeably, allowing runtime configuration and easy testing



### Final Thoughts

SOLID principles are not abstract concepts but practical guidelines that lead to cleaner, more maintainable code. This project demonstrates that following these principles from the start creates a foundation that makes future development significantly easier. The small investment in proper design pays dividends as the system grows and evolves.

---

**Date:** October 15, 2025  
**Course:** Software Design Patterns