package lab1.factory;

import lab1.models.Car;
import lab1.models.SportsCar;


public class SportsCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        SportsCar sport = new SportsCar();
        sport.setColor("Red");
        sport.setEngine("V8 Twin Turbo");
        sport.setSeats(2);
        return sport;
    }
}
