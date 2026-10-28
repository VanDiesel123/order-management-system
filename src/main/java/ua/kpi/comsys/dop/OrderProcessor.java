package ua.kpi.comsys.dop;


public class OrderProcessor {

    public String process(OrderStatus status) {

        if(status == null){
                throw new IllegalArgumentException("Status cannot be null");
        }

        return switch (status) {

            case Paid p -> """
                    Order Status: PAID
                    Details: Payment ID: %s, Amount: $%s
                    """.formatted(p.paymentID(), p.amount());

            case Pending p -> """
                    Order Status: PENDING
                    Details: Order is currently pending processing.
                    """;

            case Shipped p -> """
                    Order Status: SHIPPED
                    Details: Tracking Code: %s, Dispatch Date: %s
                    """.formatted(p.trackingCode(), p.dispatchDate());

            case Cancelled p -> """
                    Order Status: CANCELLED
                    Details: Reason: %s
                    """.formatted(p.reason());
        };
    }
}