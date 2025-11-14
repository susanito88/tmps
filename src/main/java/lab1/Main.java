package lab1;
import lab1.models.Car;
import lab1.factory.*;

public class Main {
    public static void main(String[] args) {
        ProductionManager manager1 = ProductionManager.getInstance();
        ProductionManager manager2 = ProductionManager.getInstance();

        if (manager1 == manager2) {
            System.out.println(" Singleton confirmed: both manager1 and manager2 refer to the same instance.");
        } else {
            System.out.println(" Something's wrong: different instances detected!");
        }

        manager1.log("Starting production cycle.");

        CarFactory sedanFactory = new SedanFactory();
        CarFactory suvFactory = new SUVFactory();
        CarFactory sportsFactory = new SportsCarFactory();

        Car sedan = sedanFactory.createCar();
        Car suv = suvFactory.createCar();
        Car sports = sportsFactory.createCar();

        System.out.println("Factory produced vehicles:");
        sedan.displayInfo();
        suv.displayInfo();
        sports.displayInfo();

        // Builder usage
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

        System.out.println("\nCustom builds:");
        custom1.displayInfo();
        custom2.displayInfo();

        manager1.log("Production cycle finished.");
    }
}
