package lab1.factory;

import lab1.models.Car;
import lab1.models.Sedan;


public class SedanFactory extends CarFactory {
    @Override
    public Car createCar() {
        Sedan sedan = new Sedan();
        sedan.setColor("Silver");
        sedan.setEngine("1.6L Turbo");
        sedan.setSeats(5);
        return sedan;
    }
}
