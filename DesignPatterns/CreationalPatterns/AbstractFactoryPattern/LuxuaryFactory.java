import vehicles.BmwSedan;
import vehicles.RangeroverSuv;
import vehicles.Vehicle;


public class LuxuaryFactory implements VehicleFactory{
    @Override
    public Vehicle createSedan() {
        return new BmwSedan();
    }

    @Override
    public Vehicle createSuv() {
        return new RangeroverSuv();
    }
}
