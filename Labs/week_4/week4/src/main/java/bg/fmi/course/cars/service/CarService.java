package bg.fmi.course.cars.service;

import bg.fmi.course.cars.model.Car;
import bg.fmi.course.cars.model.Invoice;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    void removeCar(Car car);

    List<Car> searchCars(String model, String make, int year, double price);
    List<Car> getAllCars();

    Invoice sellCar(Car car, String customerName);

    void printInvoice(Invoice invoice);
}
