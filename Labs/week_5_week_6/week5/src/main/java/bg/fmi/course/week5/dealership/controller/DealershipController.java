package bg.fmi.course.week5.dealership.controller;

import bg.fmi.course.week5.dealership.model.Dealership;
import bg.fmi.course.week5.dealership.service.DealershipService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealerships")
public class DealershipController {

    private final DealershipService dealershipService;

    @Autowired
    public DealershipController(DealershipService dealershipService) {
        this.dealershipService = dealershipService;
    }

    @GetMapping
    public List<Dealership> getDealerships() {
        return dealershipService.getDealerships();
    }

    @GetMapping(path = "/{name}")
    public Dealership getDealershipByName(@PathVariable("name") String name) {
        return dealershipService.getDealershipByName(name);
    }

    @PostMapping
    public void addDealershipByName(@Valid @NotNull @RequestBody Dealership dealership) {
        dealershipService.addDealership(dealership);
    }
}

