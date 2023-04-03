package bg.fmi.course.cars.repository;

import bg.fmi.course.cars.model.Invoice;

import java.util.List;

public interface InvoiceRepository {
    List<Invoice> getInvoiceHistory();
    void addInvoice(Invoice invoice);
}