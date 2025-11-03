package nl.blitz.oop.payable;

public class Contractor implements Payable {

    private final String name;
    private double dayRate;
    private double approvedDays;

    public Contractor(String name, double dayRate, double approvedDays) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (dayRate < 0) {
            throw new IllegalArgumentException("Day rate must be greater than 0");
        }
        if (approvedDays < 0) {
            throw new IllegalArgumentException("Approved days must be greater than 0");
        }
        this.name = name;
        this.dayRate = dayRate;
        this.approvedDays = approvedDays;
    }

    public String getName() {
        return name;
    }

    public double getDayRate() {
        return dayRate;
    }

    public double getApprovedDays() {
        return approvedDays;
    }

    @Override
    public double calculatePay() {
        return approvedDays * dayRate;
    }

    @Override
    public String printLine() {
        return "Contractor[" + name + "]: " + approvedDays + " d x  " + dayRate + " = " + calculatePay();
    }
}

