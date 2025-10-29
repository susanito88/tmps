package lab1.models;


public abstract class Car {
    protected String model;
    protected String color;
    protected String engine;
    protected int seats;

    public Car() {}

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    /** Display brief info about the car */
    public abstract void displayInfo();

    @Override
    public String toString() {
        return String.format("%s { color=%s, engine=%s, seats=%d }",
                (model == null ? "Car" : model), color, engine, seats);
    }
}

