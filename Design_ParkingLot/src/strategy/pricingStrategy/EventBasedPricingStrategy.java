package src.strategy.pricingStrategy;

import src.vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class EventBasedPricingStrategy implements PricingStrategy{
    // Event hourly pricing
    private static final Map<VehicleType, Double> EVENT_HOURLY_RATES = Map.of(
            VehicleType.BIKE, 30.0,
            VehicleType.CAR, 50.0,
            VehicleType.TRUCK, 70.0
    );
    @Override
    public double calculateFee(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {
        long durationOfMinutes = Duration.between(entryTime, exitTime).toMinutes();
        long hours = (long) Math.ceil((double) durationOfMinutes /60); // round up to next hour
        double ratePerHour = EVENT_HOURLY_RATES.get(vehicleType);
        return ratePerHour * hours;
    }
}
