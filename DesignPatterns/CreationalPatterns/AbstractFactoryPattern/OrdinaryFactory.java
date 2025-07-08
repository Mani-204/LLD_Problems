import vehicles.BalenoSedan;
import vehicles.BoleroSuv;
import vehicles.Vehicle;


public class OrdinaryFactory implements VehicleFactory{

    @Override
    public Vehicle createSedan() {
        return new BalenoSedan();
    }

    @Override
    public Vehicle createSuv() {
        return new BoleroSuv();
    }
}
