package bg.fmi.course.week5.dealership.controller;

import bg.fmi.course.week5.dealership.model.Car;
import bg.fmi.course.week5.dealership.model.Invoice;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bg.fmi.course.week5.dealership.service.CarService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Autowired
    public List<Car> getAllCars() {
        return this.carService.getAllCars();
    }

    public void addCar(@Valid @NotNull @RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam("make") String make, @RequestParam("model") String model,
                                @RequestParam("year") int year, @RequestParam("price")BigDecimal price) {
        return  this.carService.searchCars(make, model, year, price);
    }

    @DeleteMapping
    public void removeCar(@RequestParam("make") String make, @RequestParam("model") String model,
                          @RequestParam("year") int year, @RequestParam("price") BigDecimal price) {
        Car carToRemove = new Car(make, model, year, price);
        carService.removeCar(carToRemove);
    }

    @DeleteMapping("/sell")
    public Invoice sellCar(@RequestParam("make") String make, @RequestParam("model") String model,
                           @RequestParam("year") int year, @RequestParam("price") BigDecimal price,
                           @RequestParam("customerName") String customerName) {
        return carService.sellCar(new Car(make, model, year, price), customerName);
    }
}
