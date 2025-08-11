package src;

import src.Strategy.PaymentStrategy;

public class PaymentProcessor{
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy){
        this.strategy=strategy;
    }
    public void processPayment(double amount){
        strategy.pay(amount);
    }
}
