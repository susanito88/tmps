package lab1.models;

public class SUV extends Car {

    public SUV() {
        this.model = "SUV";
        this.color = "Silver";
        this.engine = "V6 3.0L";
        this.seats = 7;
    }

    @Override
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Body: SUV");
        System.out.println("Color: " + color);
        System.out.println("Engine: " + engine);
        System.out.println("Seats: " + seats);
        System.out.println();
    }
}
