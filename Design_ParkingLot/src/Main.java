package src;

import src.strategy.pricingStrategy.PricingStrategyFactory;
import src.strategy.pricingStrategy.PricingStrategyType;
import src.ticket.Ticket;
import src.vehicle.VehicleFactory;
import src.model.*;
import src.strategy.paymentStrategy.PaymentMode;
import src.vehicle.Vehicle;
import src.vehicle.VehicleType;

import java.time.LocalDateTime;

class Main{
    public static void main(String[] args) {
        //ParkingLot is singleton class
        ParkingLot lot = ParkingLot.getInstance();
        lot.setPricingStrategy(PricingStrategyFactory.get(PricingStrategyType.EVENT_BASED));

        //create all the entry gates
        EntryGate entryGate = new EntryGate("EG1");
        //create all the exit gates
        ExitGate exitGate = new ExitGate("XG1");

        //create all the parking floors
        ParkingFloor floor1 = new ParkingFloor("Floor1");
        //add all the spots in the floor1
        floor1.addSpot(new ParkingSpot("F1S1", VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot("F1S2", VehicleType.CAR));
        floor1.addSpot(new ParkingSpot("F1S3", VehicleType.TRUCK));
        floor1.addSpot(new ParkingSpot("F1S4", VehicleType.CAR));

        //add the floor info in the singleton parking lot class
        lot.addFloors(floor1);

        System.out.println("-----------------------------------------");

        //create vehicles coming for parking using 'factory pattern'
        Vehicle truck = VehicleFactory.create("BR01AB1234", VehicleType.TRUCK);
        Vehicle truck2 = VehicleFactory.create("BR01AB1235", VehicleType.TRUCK);

        LocalDateTime entryTime = LocalDateTime.parse("2025-08-13T10:00:00");

//        Thread thread1 = new Thread(()-> entryGate.parkVehicle(car,entryTime)); // to check concurrency
//        Thread thread2 = new Thread(()-> entryGate.parkVehicle(car2,entryTime));
//
//        thread1.start();
//        thread2.start();
//

        Ticket ticket = entryGate.parkVehicle(truck, entryTime);

        System.out.println("-----------------------------------------");

        LocalDateTime exitTime = LocalDateTime.parse("2025-08-13T17:10:00");
        exitGate.unparkVehicle(ticket, exitTime, PaymentMode.CARD);

        System.out.println("-------------------xxxxx----------------------");

    }
}