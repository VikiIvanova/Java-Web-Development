package bg.fmi.course.cars.service;

import bg.fmi.course.cars.model.Invoice;
import bg.fmi.course.cars.repository.InvoiceRepository;
import bg.fmi.course.cars.repository.InvoiceRepositoryImpl;

import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl() {
        invoiceRepository = new InvoiceRepositoryImpl();
    }
    @Override
    public void addInvoice(Invoice invoice) {
        invoiceRepository.addInvoice(invoice);
    }
    @Override
    public List<Invoice> getInvoiceHistory() {
        return invoiceRepository.getInvoiceHistory();
    }
    @Override
    public double calculateTotalPrice(Invoice invoice) {
        return invoice.getTotalPrice();
    }
}