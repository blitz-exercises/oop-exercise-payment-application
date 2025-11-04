package nl.blitz.oop.payable;

public class InvoiceItem implements Payable {

    private String description;
    private double unitPrice;
    private int quantity;

    public InvoiceItem(String description, double unitPrice, int quantity) {
        // throw new UnsupportedOperationException();
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("unit price must be greater than 0");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative or 0");
        }

        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDescription() {
        // throw new UnsupportedOperationException();
        return this.description;
    }

    public double getUnitPrice() {
        // throw new UnsupportedOperationException();
        return this.unitPrice;
    }

    public int getQuantity() {
        // throw new UnsupportedOperationException();
        return this.quantity;
    }

    @Override
    public double calculatePay() {
        // throw new UnsupportedOperationException();
        return (this.getUnitPrice() * this.getQuantity());
    }

    @Override
    public String printLine() {
        // throw new UnsupportedOperationException();
        return this.getDescription() + ": " + this.getQuantity() + " * " + this.getUnitPrice() + " = " + this.calculatePay(); 
    }
}

