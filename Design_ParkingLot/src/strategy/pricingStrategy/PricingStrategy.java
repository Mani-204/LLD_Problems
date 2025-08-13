package src.strategy.pricingStrategy;

import src.vehicle.VehicleType;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculateFee(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime);
}
