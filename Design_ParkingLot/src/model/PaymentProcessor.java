package src.model;

import src.strategy.paymentStrategy.PaymentStrategy;
import src.ticket.Ticket;

public class PaymentProcessor {
    private final PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(Ticket ticket, double amount){
        boolean success = paymentStrategy.processPayment(amount);
        if(success){
            System.out.println("Payment successful for Ticket ID: " + ticket.getId());
        }
        else{
            System.out.println("Payment failed for Ticket ID: "+ ticket.getId());
        }
    }
}
