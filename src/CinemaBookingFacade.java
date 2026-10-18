public class CinemaBookingFacade {
    private static final double TICKET_PRICE = 2500;
    private final SeatManager seatManager = new SeatManager();
    private final PaymentService paymentService = new PaymentService();
    private final TicketGenerator ticketGenerator = new TicketGenerator();
    private final NotificationService notificationService = new NotificationService();

    public void bookTicket(String movie, int seatNumber, double customerBalance) {
        System.out.println("Booking: " + movie + ", seat " + seatNumber);

        if (!seatManager.reserveSeat(seatNumber)) {
            notificationService.sendMessage("Seat is unavailable or invalid.");
            return;
        }

        if (!paymentService.pay(TICKET_PRICE, customerBalance)) {
            seatManager.releaseSeat(seatNumber);
            notificationService.sendMessage("Payment failed. Seat reservation cancelled.");
            return;
        }

        String ticket = ticketGenerator.createTicket(movie, seatNumber);
        System.out.println(ticket);
        notificationService.sendMessage("Booking successful!");
    }
}
