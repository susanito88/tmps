package lab1;
import lab1.models.*;


public class CarFactory {


    public Car createCar(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type must not be null");
        }

        switch (type.toLowerCase()) {
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            case "sportscar":
            case "sports":
            case "sport":
                return new SportsCar();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}

