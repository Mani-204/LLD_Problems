package src.model;

import src.ParkingLot;
import src.strategy.paymentStrategy.PaymentMode;
import src.ticket.Ticket;

import java.time.LocalDateTime;

public class ExitGate{
    private final String id;

    public ExitGate(String id){
        this.id=id;
    }

    public void unparkVehicle(Ticket ticket, LocalDateTime exitTime, PaymentMode paymentMode){
        ParkingLot.getInstance().unparkVehicle(ticket, exitTime, paymentMode);
    }
}
