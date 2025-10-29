package lab1;

import lab1.models.Car;
import lab1.models.CustomCar;


public class CarBuilder {
    private String model = "Custom";
    private String color = null;
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
