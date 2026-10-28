package ua.kpi.comsys.dop;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

    OrderStatus status = new Shipped("trk12345", LocalDate.of(2026, 10, 9));   
    OrderProcessor processor = new OrderProcessor();
    String result = processor.process(status);
    System.out.println(result);
    
    }
}
