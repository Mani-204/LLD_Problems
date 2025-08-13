package src.strategy.paymentStrategy;

import src.ticket.Ticket;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean processPayment(Double amount) {
        System.out.println("Paid amount $ " + amount + " through Card payment.");
        return true;
    }
}
