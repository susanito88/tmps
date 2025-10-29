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
