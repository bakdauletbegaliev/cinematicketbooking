public class Main {
    public static void main(String[] args) {
        CinemaBookingFacade cinema = new CinemaBookingFacade();

        cinema.bookTicket("Interstellar", 3, 5000); // Successful booking
        System.out.println();
        cinema.bookTicket("Interstellar", 3, 5000); // Seat already booked
        System.out.println();
        cinema.bookTicket("Interstellar", 5, 1000); // Payment fails
        System.out.println();
        cinema.bookTicket("Interstellar", 5, 3000); // Seat is available again
    }
}
