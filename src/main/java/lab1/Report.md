# Topic: Creational Design Patterns
### Course: Software Modeling & Design Techniques (aka TMPS)
### Author: Alexandru Magla | FAF-23

---

## Objectives

* Get familiar with the Creational Design Patterns (CDPs).
* Choose a specific domain — in this case, **Tutor Lessons Booking**.
* Implement at least 3 CDPs for the domain: **Builder, Singleton, Factory Method**.

---

## Introduction

- **Factory Method** - Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
- **Abstract Factory** - Lets you produce families of related objects without specifying their concrete classes.
- **Builder** - Lets you construct complex objects step by step. The patterns allows you to produce different types and representations of an object using the same construction code.
- **Prototype** - Lets you copy existing objects without making your code dependent on their classes.
- **Singleton** - Lets you ensure that a class has only one instance, while providing a global access point to this instance.

## Project Overview

This lab simulates a car production line with three main patterns:

- Builder: `CarBuilder` creates customizable `CustomCar` instances in a fluent way.
- Factory Method: `CarFactory` creates concrete `Car` subclasses (Sedan, SUV, SportsCar) based on a string type.
- Singleton: `ProductionManager` acts as a single global manager for production-related operations.

The codebase is in `src/main/java/lab1` and model classes are under `src/main/java/lab1/models`.

---

## Patterns and Implementation

### 1) Builder

Purpose: build complex or configurable `Car` instances step-by-step using a fluent API.

CarBuilder (excerpt):

```java
package lab1;

import lab1.models.Car;
import lab1.models.CustomCar;

/**
 * Simple Builder for creating a CustomCar in a fluent way.
 */
public class CarBuilder {
    private String model = "Custom";
    private String color = "Black";
    private String engine = "I4 1.6L";
    private int seats = 4;

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public Car build() {
        return new CustomCar(model, color, engine, seats);
    }
}
```

How it's used (from `Main`):

```java
Car custom1 = new CarBuilder()
        .setModel("Roadster 3000")
        .setColor("Red")
        .setEngine("V8 Turbo")
        .setSeats(2)
        .build();

Car custom2 = new CarBuilder()
        .setColor("Midnight Blue")
        .setEngine("Electric Dual Motor")
        .setSeats(5)
        .build();
```

Notes:
- The builder returns a `Car` (specifically a `CustomCar`) and lets callers customize only the fields they care about.
- Keep getters in your model classes so code that inspects `Car` instances can access properties; setters are optional depending on whether you need mutability outside the builder.

---

### 2) Factory Method

Purpose: provide a single creation method that returns different concrete `Car` subclasses depending on input.

CarFactory (excerpt):

```java
package lab1;
import lab1.models.*;

/**
 * Factory Method - creates Cars by type.
 */
public class CarFactory {

    /**
     * Create a car given a type string.
     * Recognized types: "sedan", "suv", "sportscar"
     */
    public Car createCar(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type must not be null");
        }

        switch (type.toLowerCase()) {
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            case "sportscar":
            case "sports":
            case "sport":
                return new SportsCar();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}
```

Example usage (from `Main`):

```java
CarFactory factory = new CarFactory();
Car sedan = factory.createCar("sedan");
Car suv = factory.createCar("suv");
Car sports = factory.createCar("sportscar");
```

Concrete product examples (constructors and display behavior):

Sedan:

```java
package lab1.models;

public class Sedan extends Car {

    public Sedan() {
        this.model = "Sedan";
        this.color = "White";
        this.engine = "I4 2.0L";
        this.seats = 5;
    }

    @Override
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Body: Sedan");
        System.out.println("Color: " + color);
        System.out.println("Engine: " + engine);
        System.out.println("Seats: " + seats);
        System.out.println();
    }
}
```

SUV and SportsCar follow the same pattern with their own defaults.

---

### 3) Singleton

Purpose: ensure there's a single `ProductionManager` instance coordinating production logging and high-level actions.

ProductionManager (excerpt):

```java
package lab1;

/**
 * Singleton - manages production operations.
 */
public class ProductionManager {
    private static ProductionManager instance;

    // private constructor prevents external instantiation
    private ProductionManager() {
        // initialization code
    }

    // synchronized for thread safety; simple approach
    public static synchronized ProductionManager getInstance() {
        if (instance == null) {
            instance = new ProductionManager();
        }
        return instance;
    }

    public void manageProduction() {
        System.out.println("Production Manager: managing factories and production lines...");
    }

    public void log(String message) {
        System.out.println("[Production Log] " + message);
    }
}
```

Usage (from `Main`):

```java
ProductionManager manager = ProductionManager.getInstance();
manager.manageProduction();
manager.log("Starting production cycle.");
// ... produce cars ...
manager.log("Production cycle finished.");
```

---

## Core Model: `Car` and `CustomCar`

Abstract base `Car` (excerpt):

```java
package lab1.models;

public abstract class Car {
    protected String model;
    protected String color;
    protected String engine;
    protected int seats;

    public Car() {}

    public String getModel() { return model; }
    public String getColor() { return color; }
    public String getEngine() { return engine; }
    public int getSeats() { return seats; }

    public void setColor(String color) { this.color = color; }
    public void setEngine(String engine) { this.engine = engine; }
    public void setSeats(int seats) { this.seats = seats; }

    public abstract void displayInfo();

    @Override
    public String toString() {
        return String.format("%s { color=%s, engine=%s, seats=%d }",
                (model == null ? "Car" : model), color, engine, seats);
    }
}
```

`CustomCar` created by the builder:

```java
package lab1.models;

public class CustomCar extends Car {

    public CustomCar(String model, String color, String engine, int seats) {
        this.model = model == null ? "Custom" : model;
        this.color = color;
        this.engine = engine;
        this.seats = seats;
    }

    public CustomCar(String color, String engine, int seats) {
        this("Custom", color, engine, seats);
    }

    @Override
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Custom build");
        System.out.println("Color: " + color);
        System.out.println("Engine: " + engine);
        System.out.println("Seats: " + seats);
        System.out.println();
    }
}
```

Notes on mutability:
- The project keeps getters and some setters in `Car` to allow both factory-created and builder-created instances to be adjusted if needed.
- If you prefer immutability for builder-only instances, consider making fields `final`, removing setters, and having the builder construct an immutable type.

---

## Example Run (expected console output)

When running `Main`, you should see messages from `ProductionManager`, info from `displayInfo()` on each produced car, and entries for custom builds. Example output pattern:

```
Production Manager: managing factories and production lines...
[Production Log] Starting production cycle.
Factory produced vehicles:
Model: Sedan
Body: Sedan
Color: White
Engine: I4 2.0L
Seats: 5

Model: SUV
Body: SUV
Color: Silver
Engine: V6 3.0L
Seats: 7

Model: SportsCar
Body: Sports Car
Color: Yellow
Engine: V8 5.0L
Seats: 2

Custom builds:
Model: Roadster 3000
Custom build
Color: Red
Engine: V8 Turbo
Seats: 2

Model: Custom
Custom build
Color: Midnight Blue
Engine: Electric Dual Motor
Seats: 5

[Production Log] Production cycle finished.
```

---

## Conclusions

- Builder simplifies creation of configurable `CustomCar` instances.
- Factory Method decouples client code from concrete `Car` subclasses and centralizes creation logic.
- Singleton provides a simple global manager for production coordination and logging.

---

