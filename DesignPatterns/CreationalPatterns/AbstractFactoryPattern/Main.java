import vehicles.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("What type of vehicle do you want Luxuary or Ordinary?");
        String vehicleType = sc.next();
        VehicleFactory vehicleFactory;
        if(vehicleType.contains("ordinary")){
            vehicleFactory = new OrdinaryFactory();
        }
        else if(vehicleType.contains("luxuary")){
            vehicleFactory = new LuxuaryFactory();
        }
        else{
            System.out.println("Vehicle Type is unknown");
            vehicleFactory=null;
            return;
        }

        Vehicle mysedan = vehicleFactory.createSedan();
        mysedan.getVehicleDetails();

        Vehicle mysuv = vehicleFactory.createSuv();
        mysuv.getVehicleDetails();
    }
}
