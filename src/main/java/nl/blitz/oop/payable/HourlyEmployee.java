package nl.blitz.oop.payable;

public class HourlyEmployee implements Payable {

    private final String name;
    private double hourlyRate;
    private double approvedHours;

    public HourlyEmployee(String name, double hourlyRate, double approvedHours) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate must be greater than 0");
        }
        if (approvedHours < 0) {
            throw new IllegalArgumentException("Approved hours must be greater than 0");
        }
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.approvedHours = approvedHours;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate must be greater than 0");
        }
        this.hourlyRate = hourlyRate;
    }

    public double getApprovedHours() {
        return approvedHours;
    }

    @Override
    public double calculatePay() {
        return approvedHours * hourlyRate;
    }

    @Override
    public String printLine() {
        return "HourlyEmployee[" + name + "]: " + approvedHours + " h x  " + hourlyRate + " = " + calculatePay();
    }
}

