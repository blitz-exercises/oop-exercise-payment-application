package nl.blitz.oop.payable;

public class Contractor implements Payable {

    private String name;
    private double dayRate;
    private double approvedDays;

    public Contractor(String name, double dayRate, double approvedDays) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public double getDayRate() {
        throw new UnsupportedOperationException();
    }

    public double getApprovedDays() {
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

