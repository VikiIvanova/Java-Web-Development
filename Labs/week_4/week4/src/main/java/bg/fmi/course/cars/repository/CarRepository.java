package bg.fmi.course.cars.repository;

import bg.fmi.course.cars.model.Car;

import java.util.List;

public interface CarRepository {
    List<Car> getAllCars();
    List<Car> searchCars(String make, String model, Integer year, Double price);
    void addCar(Car car);
    void removeCar(Car car);
}