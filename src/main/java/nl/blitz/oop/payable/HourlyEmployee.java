package nl.blitz.oop.payable;

public class HourlyEmployee implements Payable {

    private String name;
    private double hourlyRate;
    private double approvedHours;

    public HourlyEmployee(String name, double hourlyRate, double approvedHours) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public double getHourlyRate() {
        throw new UnsupportedOperationException();
    }

    public double getApprovedHours() {
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

