package nl.blitz.oop.payable;

public class HourlyEmployee implements Payable {

    private final String name;
    private double hourlyRate;
    private double approvedHours;

    public HourlyEmployee(String name, double hourlyRate, double approvedHours) {
        // throw new UnsupportedOperationException();
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (hourlyRate <= 0) {
            throw new IllegalArgumentException("hourly rate must be higher than 0");
        } else if (approvedHours < 0) {
            throw new IllegalArgumentException("approvedHours cannot be negative");
        }

        this.name = name;
        this.hourlyRate = hourlyRate;
        this.approvedHours = approvedHours;
    }

    public String getName() {
        // throw new UnsupportedOperationException();
        return this.name;
    }

    public double getHourlyRate() {
        // throw new UnsupportedOperationException();
        return this.hourlyRate;
    }

    public double getApprovedHours() {
        // throw new UnsupportedOperationException();
        return this.approvedHours;
    }

    @Override
    public double calculatePay() {
        // throw new UnsupportedOperationException();
        return (this.getHourlyRate() * this.getApprovedHours());
    }

    @Override
    public String printLine() {
        // throw new UnsupportedOperationException();
        return this.getName() + ": Pay is: " + this.getHourlyRate() + " * "
                + this.getApprovedHours() + " = " + this.calculatePay();
    }
}

