package ua.kpi.comsys.dop;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderProcessorTest {
    @Test
    public void TestPending(){
        OrderProcessor processor = new OrderProcessor();
        OrderStatus status = new Pending();
        String result = processor.process(status);

        String Expected = """
                Order Status: PENDING
                Details: Order is currently pending processing.
                """;
        assertEquals(Expected, result);
    }
    @Test
    public void TestPaid(){
        OrderProcessor processor = new OrderProcessor();
        OrderStatus status = new Paid("ABCD", new BigDecimal(123.00));
        String result = processor.process(status);
        
        String Expected = """
                Order Status: PAID
                Details: Payment ID: ABCD, Amount: $123
                """;
        assertEquals(Expected, result);
    }
    @Test
    public void TestShipped(){
        OrderProcessor processor = new OrderProcessor();
        OrderStatus status = new Shipped("ABCD", LocalDate.of(2026, 10, 28));
        String result = processor.process(status);

        String Expected = """
                Order Status: SHIPPED
                Details: Tracking Code: ABCD, Dispatch Date: 2026-10-28
                """;
        assertEquals(Expected, result);
    }
    @Test
    public void testCancelled() {
        OrderProcessor processor = new OrderProcessor();

        OrderStatus status = new Cancelled("Customer request");

        String result = processor.process(status);

        String expected = """
                Order Status: CANCELLED
                Details: Reason: Customer request
                """;

        assertEquals(expected, result);
    }
    @Test 
    public void TestStatusNull(){
        OrderProcessor processor = new OrderProcessor();
        
        assertThrows(
        IllegalArgumentException.class,
        () -> processor.process(null));
    }
}
