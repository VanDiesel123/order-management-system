package ua.kpi.comsys.dop;


import java.math.BigDecimal;

public record Paid (String paymentID, java.math.BigDecimal amount) implements OrderStatus{


    public Paid{
    if (paymentID == null 
        || paymentID.isBlank() 
        || amount == null 
        || amount.compareTo(BigDecimal.ZERO) <= 0) {

        throw new IllegalArgumentException();
        
        }
    }
}