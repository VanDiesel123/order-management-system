package ua.kpi.comsys.dop;


public record Shipped (String trackingCode, java.time.LocalDate dispatchDate) implements OrderStatus{

    public Shipped{
        if (trackingCode == null
            || trackingCode.isBlank()
            || dispatchDate == null
        ) {
            throw new IllegalArgumentException();
        }
    }

}