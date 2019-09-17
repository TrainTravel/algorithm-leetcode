package OOD.ParkingLot.Vehicle;

import OOD.ParkingLot.ParkingSpot.Spot;

/**
 * @author BorisMirage
 * Time: 2019/08/29 18:17
 * Created with IntelliJ IDEA
 */

public class Compact extends Vehicle {

    public Compact() {
        requiredSpots = 1;
        size = VehicleSize.Compact;
    }

    public void setPlate(String plate) {
        license = plate;
    }

    @Override
    public boolean fitSpot(Spot s) {
        return true;        // TODO: MODIFY WITH SPOT
    }

    @Override
    public void log() {

    }
}
