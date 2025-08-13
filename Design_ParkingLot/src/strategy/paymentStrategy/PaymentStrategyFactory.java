package src.strategy.paymentStrategy;

public class PaymentStrategyFactory {
    public static PaymentStrategy get(PaymentMode paymentMode) {
        return switch (paymentMode){
            case CASH -> new CashPaymentStrategy();
            case UPI -> new UpiPaymentStrategy();
            case CARD -> new CardPaymentStrategy();
        };
    }
}
