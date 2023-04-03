package bg.fmi.course.cars.service;

import bg.fmi.course.cars.model.Invoice;

import java.util.List;

public interface InvoiceService {

    void addInvoice(Invoice invoice);

    List<Invoice> getInvoiceHistory();

    double calculateTotalPrice(Invoice invoice);
}