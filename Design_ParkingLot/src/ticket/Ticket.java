package src.ticket;

import src.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private String floorId;
    private String spotId;

    public Ticket(String id, Vehicle vehicle, LocalDateTime entryTime, String floorId, String spotId) {
        this.id = id;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.floorId = floorId;
        this.spotId = spotId;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getSpotId() {
        return spotId;
    }
}
