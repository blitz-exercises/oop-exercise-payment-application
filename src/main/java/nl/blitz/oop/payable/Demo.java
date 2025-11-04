package nl.blitz.oop.payable;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        HourlyEmployee he1 = new HourlyEmployee("Anne", 30, 38);
        HourlyEmployee he2 = new HourlyEmployee("Max", 32, 37);
        
        Contractor c1 = new Contractor("Rob", 250, 20); 
        Contractor c2 = new Contractor("Emily", 350, 25); 

        InvoiceItem item1 = new InvoiceItem("Keyboard", 100.5, 1);
        InvoiceItem item2 = new InvoiceItem("Pen", 2.2, 40);

        List<Payable> payables = new ArrayList<>();
        payables.add(he1);
        payables.add(he2);
        payables.add(c1);
        payables.add(c2);
        payables.add(item1);
        payables.add(item2);

        double grandTotal = 0;
        for (Payable p : payables) {
            System.out.println(p.printLine());
            grandTotal += p.calculatePay();
        }

        System.out.println("Grand Total: " + grandTotal);
    }
}

