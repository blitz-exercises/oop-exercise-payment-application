package nl.blitz.oop.payable;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Payable> payables = new ArrayList<>();

        HourlyEmployee employee1 = new HourlyEmployee("John", 35.0, 40.0);
        HourlyEmployee employee2 = new HourlyEmployee("Emma", 27.50, 24);
        Contractor contractor1 = new Contractor("Jane", 100.0, 10.0);
        Contractor contractor2 = new Contractor("Bob", 150.0, 15.0);
        InvoiceItem item1 = new InvoiceItem("Computer", 975, 25);
        InvoiceItem item2 = new InvoiceItem("Chair", 250, 4);

        payables.add(employee1);
        payables.add(employee2);
        payables.add(contractor1);
        payables.add(contractor2);
        payables.add(item1);
        payables.add(item2);

        for (Payable payable : payables) {
            if (payable instanceof InvoiceItem) {
                System.out.println("Description: " + ((InvoiceItem) payable).getDescription());
            }
            System.out.println(payable.printLine());
        }
    }
}

