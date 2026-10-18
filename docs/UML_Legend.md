# UML Diagram — Class and Relationship Legend

## Classes

- **Main (Client):** Entry point (`main`). Creates only `CinemaBookingFacade` and asks it to book tickets.
- **CinemaBookingFacade (Facade):** Public method `bookTicket(String movie, int seatNumber, double customerBalance)`; organizes the entire process in the proper order.
- **SeatManager (Subsystem):** Tracks 10 seats; `isAvailable` checks seat number and availability, `reserveSeat` reserves it, and `releaseSeat` undoes reservations after failed payment.
- **PaymentService (Subsystem):** `pay` returns whether the provided balance covers a positive ticket price. It is a simulation, not a bank transaction.
- **TicketGenerator (Subsystem):** `createTicket` formats a ticket string for a movie and seat.
- **NotificationService (Subsystem):** `sendMessage` prints booking status to the terminal.

## Relationships

- `Main --> CinemaBookingFacade`: client **uses** the facade only.
- `CinemaBookingFacade --> SeatManager`: facade **checks/reserves/releases** a seat.
- `CinemaBookingFacade --> PaymentService`: facade **checks payment**.
- `CinemaBookingFacade --> TicketGenerator`: facade **creates ticket** only after payment succeeds.
- `CinemaBookingFacade --> NotificationService`: facade **shows status** for success or failure.

## Notation

- Rectangle: Java class, its public methods, and role.
- Solid arrow: **uses / has a dependency on** the destination class. The arrow points to the used class.
- `+` before a method: **public** visibility.
- `:` after a method: return type.
- This diagram shows simplified public APIs; private fields are omitted for readability.
