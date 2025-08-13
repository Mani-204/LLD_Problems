package src.model;

import src.ParkingLot;
import src.ticket.Ticket;
import src.vehicle.Vehicle;

import java.time.LocalDateTime;

public class EntryGate{
    private final String id;

    public EntryGate(String id){
        this.id=id;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return ParkingLot.getInstance().parkVehicle(vehicle, entryTime);
    }

}
