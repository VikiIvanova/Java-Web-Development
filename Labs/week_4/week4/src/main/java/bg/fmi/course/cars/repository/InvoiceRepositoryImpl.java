package bg.fmi.course.cars.repository;

import bg.fmi.course.cars.model.Invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceRepositoryImpl implements InvoiceRepository {
    private Map<String, Invoice> db;

    public InvoiceRepositoryImpl(){
        db = new HashMap<>();
    }
    @Override
    public void addInvoice(Invoice invoice){
        db.put(invoice.getId(), invoice);
    }
    @Override
    public List<Invoice> getInvoiceHistory(){
        return db.values()
                .stream()
                .toList();
    }

}