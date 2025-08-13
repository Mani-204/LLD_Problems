package src.vehicle;

public class Vehicle {
    private final String number;
    private final VehicleType type;

    Vehicle(String number, VehicleType type){
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getType() {
        return type;
    }
}
