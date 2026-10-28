Order Management System

A simple Java project for processing different order statuses.

Technologies

- Java 21
- Maven
- JUnit 5

Order Statuses

The project supports the following statuses:

- Pending
- Paid
- Shipped
- Cancelled

Functionality

The `OrderProcessor` class processes an order status and returns information about the current state of the order.

The project also handles invalid input. If the status is `null`, the program throws an `IllegalArgumentException`.

Testing

Unit tests are implemented using JUnit 5.

The tests cover:

- Pending status
- Paid status
- Shipped status
- Cancelled status
- `null` input

To run the tests, use:

bash
mvn test


Project Structure

text
src/
├── main/
│   └── java/
│       └── ua/kpi/comsys/dop/
└── test/
    └── java/
        └── ua/kpi/comsys/dop/
