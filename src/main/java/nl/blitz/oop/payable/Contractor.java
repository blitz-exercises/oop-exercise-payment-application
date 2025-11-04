package nl.blitz.oop.payable;

public class Contractor implements Payable {

    private final String name;
    private double dayRate;
    private double approvedDays;

    public Contractor(String name, double dayRate, double approvedDays) {
        // throw new UnsupportedOperationException();
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (dayRate <= 0) {
            throw new IllegalArgumentException("dayrate must be positive");
        }
        if (approvedDays < 0) {
            throw new IllegalArgumentException("approved days cannot be negative");
        }

        this.name = name;
        this.dayRate = dayRate;
        this.approvedDays = approvedDays;
    }

    public String getName() {
        // throw new UnsupportedOperationException();
        return this.name;
    }

    public double getDayRate() {
        // throw new UnsupportedOperationException();
        return this.dayRate;
    }

    public double getApprovedDays() {
        // throw new UnsupportedOperationException();
        return this.approvedDays;
    }

    @Override
    public double calculatePay() {
        // throw new UnsupportedOperationException();
        return (this.getDayRate() * this.getApprovedDays());
    }

    @Override
    public String printLine() {
        // throw new UnsupportedOperationException();
        return "Contractor: " + this.getName() + " Pay is: " + this.calculatePay();
    }
}

