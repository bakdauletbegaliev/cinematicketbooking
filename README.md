# Cinema Ticket Booking — Facade Pattern

**Assignment #4 | Java 17 | SE-2526 | BEGALIYEV BAKDAULET**

GitHub repository: https://github.com/bakdauletbegaliev/cinematicketbooking

## Overview

This small console app demonstrates the structural **Facade** pattern. Instead of handling multiple cinema services, the client (`Main`) calls one method: `CinemaBookingFacade.bookTicket(movie, seatNumber, customerBalance)`.

## Project files

```text
CinemaTicketFacade/
  src/
    Main.java
    CinemaBookingFacade.java
    SeatManager.java
    PaymentService.java
    TicketGenerator.java
    NotificationService.java
  docs/
    Cinema_UML.png
    Cinema_UML.pdf
    Assignment4_Report.pdf
    UML_Legend.md
  START_HERE.txt
  run.bat
  run.sh
  docs/Cinema_UML.puml
  demo-output.txt
  README.md
```

## Run

Requires **JDK 17** or newer. Open a terminal in the project folder:

```bash
javac -d out src/*.java
java -cp out Main
```

In IntelliJ IDEA, open the project folder, set JDK 17, and run `Main.java`.

## Demo cases

1. Reserve seat 3 successfully.
2. Try to reserve seat 3 again; it is unavailable.
3. Try seat 5 with insufficient balance; payment is declined and the seat is released.
4. Retry seat 5 with sufficient balance; booking succeeds.

## Design

- **Main:** client; uses only the facade.
- **CinemaBookingFacade:** controls the correct booking sequence.
- **SeatManager:** checks, reserves, and releases seats (ten seats in this simulation).
- **PaymentService:** checks a simulated balance, not a real charge.
- **TicketGenerator:** creates ticket text.
- **NotificationService:** prints status messages to the console.

View `docs/Cinema_UML.png` for the full diagram and `docs/UML_Legend.md` for its legend. The report is `docs/Assignment4_Report.pdf`.

## Limits and course notes

This is a simplified educational simulation with one set of seats stored in memory, console notifications, and no real bank processing. The user balance is **checked**, not debited. The free-choice topic (Option C) needs instructor approval. Review and adapt this reference example yourself before submitting; the course requires independent work and an individual defense.

## Suggested development commits

Make genuine commits while implementing or customizing your work; do not fabricate commit history:

1. `Add seat manager and reservation logic`
2. `Add payment ticket and notification services`
3. `Implement booking facade and rollback`
4. `Add client examples UML and report`

## Questions for defense

**What does the facade hide?** Seat management, payment decision, ticket creation and notification order.

**Why does the facade release the seat?** If payment fails, the reservation must be undone so it does not block other buyers.

**Can subsystem classes be used directly?** Yes. They do not know about the facade, although this client intentionally uses only the facade.

## One-click launch

On Windows, run `run.bat` with JDK 17+ installed. On macOS/Linux, run `bash run.sh`. The PDF report and UML diagrams are already included in `docs/`.
