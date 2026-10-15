public class SeatManager {
    private final boolean[] bookedSeats = new boolean[10];

    public boolean isAvailable(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= 10 && !bookedSeats[seatNumber - 1];
    }

    public boolean reserveSeat(int seatNumber) {
        if (!isAvailable(seatNumber)) {
            return false;
        }
        bookedSeats[seatNumber - 1] = true;
        return true;
    }

    public void releaseSeat(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= 10) {
            bookedSeats[seatNumber - 1] = false;
        }
    }
}
