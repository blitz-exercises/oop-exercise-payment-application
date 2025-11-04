package nl.blitz.oop.payable;

public class Contractor implements Payable {

    private final String name;
    private double dayRate;
    private double approvedDays;

    public Contractor(String name, double dayRate, double approvedDays) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if(dayRate <= 0){
            throw new IllegalArgumentException("Day rate cannot be less then 0.");
        }

        if(approvedDays <=0){
            throw new IllegalArgumentException("Approved days cannot be a negative number.");
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
        return dayRate * approvedDays;
    }

    @Override
    public String printLine() {
                return "Contractor[" + name + "]: " +
                dayRate + " d x " +
                approvedDays + " = " +
                calculatePay();
    }
}

