package nl.blitz.oop.payable;

public class InvoiceItem implements Payable {

    private String description;
    private double unitPrice;
    private int quantity;

    public InvoiceItem(String description, double unitPrice, int quantity) {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getUnitPrice() {
        throw new UnsupportedOperationException();
    }

    public int getQuantity() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double calculatePay() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String printLine() {
        throw new UnsupportedOperationException();
    }
}

