package lab1.models;

public class SportsCar extends Car {

    public SportsCar() {
        this.model = "SportsCar";
        this.color = "Yellow";
        this.engine = "V8 5.0L";
        this.seats = 2;
    }

    @Override
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Body: Sports Car");
        System.out.println("Color: " + color);
        System.out.println("Engine: " + engine);
        System.out.println("Seats: " + seats);
        System.out.println();
    }
}
