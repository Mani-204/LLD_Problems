package src.strategy.paymentStrategy;

import src.ticket.Ticket;

public class UpiPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean processPayment(Double amount) {
        System.out.println("Paid amount $ " + amount + " through Upi payment.");
        return true;
    }
}
