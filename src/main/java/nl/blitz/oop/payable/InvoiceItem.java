package nl.blitz.oop.payable;

public class InvoiceItem implements Payable {

    private String description;
    private double unitPrice;
    private int quantity;

    public InvoiceItem(String description, double unitPrice, int quantity) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }

        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than 0.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculatePay() {
        return unitPrice * quantity;
    }

    @Override
    public String printLine() {
        return "InvoiceItem[" + description + "]: " +
               quantity + " × " + unitPrice + " = " + calculatePay();
    }
}

