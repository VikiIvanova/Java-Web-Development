package bg.fmi.course.week5.dealership.repository;

import bg.fmi.course.week5.dealership.model.Car;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    private List<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void removeCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> searchCars(String make, String model, int year, BigDecimal price) {
        return this.cars.stream()
                .filter(car->
                             car.getMake().equals(make) &&
                             car.getModel().equals(model) &&
                              car.getYear() == year &&
                                     car.getPrice().equals(price)).collect(Collectors.toList());

    }

    public List<Car> getAllCars() {
        return this.cars;
    }
}
