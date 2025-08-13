package src.strategy.paymentStrategy;

import src.ticket.Ticket;

public interface PaymentStrategy {
    boolean processPayment(Double amount);
}
