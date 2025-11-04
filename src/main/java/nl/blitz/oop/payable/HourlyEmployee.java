package nl.blitz.oop.payable;

public class HourlyEmployee implements Payable {

    private final String name;
    private double hourlyRate;
    private double approvedHours;

    public HourlyEmployee(String name, double hourlyRate, double approvedHours) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if(hourlyRate < 0){
            throw new IllegalArgumentException("Hourly rate cannot be less then 0.");
        }

        if(approvedHours <= 0){
            throw new IllegalArgumentException("Approved hours cannot be a negative number.");
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

    public double getApprovedHours() {
        return approvedHours;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * approvedHours;
    }

    @Override
    public String printLine() {
        return "HourlyEmployee[" + name + "]: " +
                hourlyRate + " h x " +
                approvedHours + " = " +
                calculatePay();
    }
}

