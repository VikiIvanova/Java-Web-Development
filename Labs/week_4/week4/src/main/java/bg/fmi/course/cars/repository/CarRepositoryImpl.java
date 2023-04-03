package bg.fmi.course.cars.repository;

import bg.fmi.course.cars.model.Car;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class CarRepositoryImpl implements CarRepository {
    private Map<String, Car> db;

    public CarRepositoryImpl() {
        this.db = new HashMap<>();
    }

    @Override
    public List<Car> getAllCars() {
        var cars = db.values()
                .stream()
                .toList();
        return cars;
    }

    @Override
    public List<Car> searchCars(String make, String model, Integer year, Double price) {
        return db.values()
                .stream()
                .filter(car ->
                        car.getModel().equals(model) &&
                                car.getMake().equals(make) &&
                                car.getYear() == year &&
                                car.getPrice() == price
                ).collect(Collectors.toList());
    }

    @Override
    public void addCar(Car car) {
        db.put(car.getID(), car);
    }

    @Override
    public void removeCar(Car car) {
        db.remove(car.getID());
    }
}