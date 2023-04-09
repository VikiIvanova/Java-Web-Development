package bg.fmi.course.week5.dealership.repository;

import bg.fmi.course.week5.dealership.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {
    private List<Invoice> invoiceHistory = new ArrayList<>();

    public void addInvoice(Invoice invoice) {
        invoiceHistory.add(invoice);
    }

    public List<Invoice> getInvoiceHistory() {
        return invoiceHistory;
    }
}
