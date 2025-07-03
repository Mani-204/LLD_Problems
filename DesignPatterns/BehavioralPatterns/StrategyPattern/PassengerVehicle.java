import Strategy.DriveStrategy;
import Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{

    PassengerVehicle(){
        super(new NormalDriveStrategy());
    }
}
