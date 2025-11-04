package nl.blitz.oop.payable;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // throw new UnsupportedOperationException();
        ArrayList<Payable> payables = new ArrayList<Payable>();

        HourlyEmployee hEmployee = new HourlyEmployee("John", 6, 10);
        Contractor contractor = new Contractor("Smith BV", 30, 4);
        InvoiceItem invoiceItem = new InvoiceItem("Work done", 200, 1);

        payables.add(hEmployee);
        payables.add(contractor);
        payables.add(invoiceItem);

        double total = 0;
        for (Payable payable : payables) {
            System.out.println(payable.printLine());
            total += payable.calculatePay();
        }
        System.out.println("total: " + total);
    }
}

