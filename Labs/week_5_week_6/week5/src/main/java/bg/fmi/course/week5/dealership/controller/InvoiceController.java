package bg.fmi.course.week5.dealership.controller;

import bg.fmi.course.week5.dealership.model.Car;
import bg.fmi.course.week5.dealership.model.Invoice;
import bg.fmi.course.week5.dealership.service.InvoiceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public void addInvoice(@Valid @NotNull @RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> getInvoiceHistory() {
        return invoiceService.getInvoiceHistory();
    }

    @GetMapping("/totalPrice")
    public BigDecimal calculateTotalPrice(@RequestParam("customerName") String customerName,
                                          @RequestParam("purchaseDate")LocalDate purchaseData,
                                          @RequestParam("carMake") String make,
                                          @RequestParam("carModel") String model,
                                          @RequestParam("year") int year,
                                          @RequestParam("price")BigDecimal price,
                                          @RequestParam("salesPrice") BigDecimal salesPrice,
                                          @RequestParam("taxRate") BigDecimal taxRate) {
        return invoiceService.calculateTotalPrice(new Invoice(customerName, purchaseData,
                new Car(make, model, year, price), salesPrice, taxRate));
    }
}
