package Strategy;

public class NormalDriveStrategy implements DriveStrategy{

    @Override
    public void drive(){
        System.out.println("Vehicle is having normal drive capability");
    }
}
