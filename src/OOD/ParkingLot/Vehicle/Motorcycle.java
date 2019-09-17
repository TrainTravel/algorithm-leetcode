package OOD.ParkingLot.Vehicle;

import OOD.ParkingLot.ParkingSpot.Spot;

/**
 * @author BorisMirage
 * Time: 2019/08/29 18:14
 * Created with IntelliJ IDEA
 */


public class Motorcycle extends Vehicle {
    public Motorcycle() {
        requiredSpots = 1;
        size = VehicleSize.Motorcycle;
    }

    public void setPlate(String plate) {
        license = plate;
    }

    @Override
    public boolean fitSpot(Spot s) {
        return true;
    }

    @Override
    public void log() {

    }
}

