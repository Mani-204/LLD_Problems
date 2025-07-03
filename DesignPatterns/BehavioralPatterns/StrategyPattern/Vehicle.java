import Strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy obj){
        this.driveStrategy=obj;
    }

    void driveVehicle(){
        driveStrategy.drive();
    }

}
