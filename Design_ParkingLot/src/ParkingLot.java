package src;

import src.model.*;
import src.strategy.paymentStrategy.PaymentMode;
import src.strategy.paymentStrategy.PaymentStrategy;
import src.strategy.paymentStrategy.PaymentStrategyFactory;
import src.strategy.pricingStrategy.PricingStrategy;
import src.ticket.Ticket;
import src.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();

    public void setGeneratedTickets(Map<String, Ticket> generatedTickets) {
        this.generatedTickets = generatedTickets;
    }

    private PricingStrategy pricingStrategy;
    private final Map<String, ParkingFloor> floors = new HashMap<>();

    private Map<String, Ticket> generatedTickets = new HashMap<>();


    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }

    public static ParkingLot getInstance(){
        return INSTANCE;
    }

    public void addFloors(ParkingFloor floor){
        floors.put(floor.getId(),floor);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {
        for(ParkingFloor floor: floors.values()){
            ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());
            if(spot!=null){
                //successfully reserved the spot
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle, entryTime, floor.getId(), spot.getId());
                generatedTickets.put(ticketId, ticket);
                spot.tryOccupy();
                System.out.println("Vehicle parked. Ticket: "+ticketId);
                return ticket;
            }
        }
        System.out.println("No spots available for vehicle type: "+ vehicle.getType());
        return null;
    }

    public void unparkVehicle(Ticket ticket, LocalDateTime exitTime, PaymentMode paymentMode) {
        if(ticket==null){
            System.out.println("Invalid ticket id.");
            return;
        }
        double fee=pricingStrategy.calculateFee(ticket.getVehicle().getType(), ticket.getEntryTime(), exitTime);

        PaymentStrategy strategy = PaymentStrategyFactory.get(paymentMode);
        PaymentProcessor processor = new PaymentProcessor(strategy);
        processor.pay(ticket, fee);
        generatedTickets.remove(ticket.getId());
        ParkingSpot spot = floors.get(ticket.getFloorId()).getSpots().get(ticket.getSpotId());
        spot.vacate();


        System.out.println("Vehicle exited. Fee charged: $"+fee);
    }


}
