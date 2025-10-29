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

