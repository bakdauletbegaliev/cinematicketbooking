public class PaymentService {
    public boolean pay(double amount, double customerBalance) {
        if (amount <= 0) {
            return false;
        }
        return customerBalance >= amount;
    }
}
