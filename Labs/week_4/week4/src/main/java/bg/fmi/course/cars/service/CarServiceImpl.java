package bg.fmi.course.cars.service;

import bg.fmi.course.cars.model.Car;
import bg.fmi.course.cars.model.Invoice;
import bg.fmi.course.cars.repository.CarRepository;
import bg.fmi.course.cars.repository.CarRepositoryImpl;

import java.util.List;

public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl() {
        carRepository = new CarRepositoryImpl();
    }

    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }
    @Override
    public void removeCar(Car car) {
        carRepository.removeCar(car);
    }
    @Override
    public List<Car> searchCars(String model, String make, int year, double price) {
        return carRepository.searchCars(make, model, year, price);
    }
    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }
    @Override
    public Invoice sellCar(Car car, String customerName) {
        Invoice invoice = new Invoice(customerName, car);
        return invoice;
    }
    @Override
    public void printInvoice(Invoice invoice) {
        System.out.println(invoice);
    }

}
