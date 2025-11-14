package lab1.factory;

import lab1.models.Car;
import lab1.models.SUV;


public class SUVFactory extends CarFactory {
    @Override
    public Car createCar() {
        SUV suv = new SUV();
        suv.setColor("Black");
        suv.setEngine("2.0L Diesel");
        suv.setSeats(7);
        return suv;
    }
}
