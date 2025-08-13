package src.model;

import src.vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private long entryTime;
    private long exitTime;
    private Vehicle v;
    private String ticketID;
    private ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.entryTime = new Date().getTime();
        this.parkingSpot=parkingSpot;
        this.v=vehicle;
        this.ticketID = UUID.randomUUID().toString();
    }

    public String getTicketID() {
        return ticketID;
    }
    public long getExitTime() {
        return exitTime;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getV() {
        return v;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

}
