package src.model;

import src.vehicle.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private final String id;
    private final VehicleType allowedType;

    private Boolean occupied = false;

    public ParkingSpot(String id, VehicleType allowedType) {
        this.id = id;
        this.allowedType = allowedType;
    }


    public synchronized boolean tryOccupy(){
        if(occupied){
            return false;
        }
        occupied = true;
        return occupied;
    }

    public void vacate(){
        occupied=false;
    }

    public boolean isOccupied(){
        return occupied;
    }


    public String getId() {
        return id;
    }

    public VehicleType getAllowedType() {
        return allowedType;
    }
}
