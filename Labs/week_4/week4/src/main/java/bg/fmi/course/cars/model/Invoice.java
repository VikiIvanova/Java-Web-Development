package bg.fmi.course.cars.model;

import java.util.Date;

public class Invoice {
    private String id;
    private String customerName;
    private Date purchaseDate;
    private Car car;
    private double salesPrice;
    private double taxRate;

    public String getId() {
        return this.id;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public Car getCar() {
        return this.car;
    }

    public double getSalesPrice() {
        return this.salesPrice;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public void setId(String id){
        if(id.equals("")){
            throw new NullPointerException("Id should be not empty");
        } else {
            this.id = id;
        }
    }

    public void setCustomerName(String customerName) {
        if (customerName.equals("")) {
            throw new RuntimeException("Customer name should not be empty!");
        } else {
            this.customerName = customerName;
        }
    }

    public void setPurchaseDate(Date purchaseDate) {
        if (purchaseDate.equals(null)) {
            throw new RuntimeException("Purchase date should not be empty!");
        } else {
            this.purchaseDate = purchaseDate;
        }
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setSalesPrice(double salesPrice) {
        if (salesPrice < 0) {
            throw new RuntimeException("Price should be positive");
        } else {
            this.salesPrice = salesPrice;
        }
    }

    public void setTaxRate(double taxRate) {
        if (taxRate < 0) {
            throw new RuntimeException("Tax rate should be positive!");
        } else {
            this.taxRate = taxRate;
        }
    }

    public Invoice(String id, String customerName, Date purchaseDate, Car car, double salesPrice, double taxRate) {
        setId(id);
        setCustomerName(customerName);
        setPurchaseDate(purchaseDate);
        setCar(car);
        setSalesPrice(salesPrice);
        setTaxRate(taxRate);
    }

    public Invoice(String customerName, Car car) {
        setCar(car);
        setCustomerName(customerName);
    }

    public double getTotalPrice() {
        return getSalesPrice() * getTaxRate() + getSalesPrice();
    }

    @Override
    public String toString() {
        return  "\nInvoice ID: " + getId() +
                "\nCustomer name: " + getCustomerName() +
                "\nPurchase date: " + getPurchaseDate() +
                "\nCar: \n\t" + getCar() +
                "\nSales price: " + getSalesPrice() +
                "\nTax rate: " + getTaxRate();
    }
}