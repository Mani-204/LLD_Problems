package src.strategy.pricingStrategy;

import src.vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

public class TimeBasedPricingStrategy implements PricingStrategy{
    // Peak period hours (eg: 8:00 to 17:00)
    private static final LocalTime PEAK_START = LocalTime.of(8,0);
    private static final LocalTime PEAK_END = LocalTime.of(17,0);

    // Time hourly pricing
    private static final Map<VehicleType, Double> PEAK_HOURLY_RATES = Map.of(
            VehicleType.BIKE, 30.0,
            VehicleType.CAR, 50.0,
            VehicleType.TRUCK, 70.0
    );
    private static final Map<VehicleType, Double> NONPEAK_HOURLY_RATES = Map.of(
            VehicleType.BIKE, 20.0,
            VehicleType.CAR, 40.0,
            VehicleType.TRUCK, 60.0
    );

    @Override
    public double calculateFee(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {
        if(exitTime.isBefore(entryTime)){
            throw new IllegalArgumentException("Exit time is before the entry time");
        }
        long durationOfMinutes = Duration.between(entryTime, exitTime).toMinutes();
        long hours = (long) Math.ceil((double) durationOfMinutes /60); // round up to next hour

        long peakHours = 0;
        long nonpeakHours =0;

        //contains logic to find peak nad nonpeak hours

        double peakRatePerHour = PEAK_HOURLY_RATES.get(vehicleType);
        double nonpeakRatePerHour = NONPEAK_HOURLY_RATES.get(vehicleType);

        return peakRatePerHour * peakHours + nonpeakRatePerHour*nonpeakHours;
    }
}
