package src.strategy.pricingStrategy;

public class PricingStrategyFactory {
    public static PricingStrategy get(PricingStrategyType type) {
        return switch(type){
            case TIME_BASED -> new TimeBasedPricingStrategy();
            case EVENT_BASED -> new EventBasedPricingStrategy();
        };
    }
}
