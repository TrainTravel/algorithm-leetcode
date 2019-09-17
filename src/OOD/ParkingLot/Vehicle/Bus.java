package OOD.ParkingLot.Vehicle;

import OOD.ParkingLot.ParkingSpot.Spot;

/**
 * @author BorisMirage
 * Time: 2019/08/29 18:18
 * Created with IntelliJ IDEA
 */

public class Bus extends Vehicle{
    public Bus() {
        requiredSpots = 5;
        size = VehicleSize.Large;
    }

    public void setPlate(String license) {
        this.license = license;
    }

    @Override
    public boolean fitSpot(Spot s) {
        return true;        // TODO: MODIFY WITH SPOT
    }

    @Override
    public void log() {

    }
}
