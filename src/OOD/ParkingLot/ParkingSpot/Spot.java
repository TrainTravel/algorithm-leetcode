package OOD.ParkingLot.ParkingSpot;

import OOD.ParkingLot.Vehicle.Vehicle;
import OOD.ParkingLot.Vehicle.VehicleSize;

/**
 * @author BorisMirage
 * Time: 2019/08/29 18:34
 * Created with IntelliJ IDEA
 */

public class Spot {
    protected Vehicle vehicle;
    protected VehicleSize vehicleSize;
    protected int row;
    protected int number;
    private Level level;

    public Spot(Level level, int row, int number, VehicleSize size) {
        this.level = level;
        this.row = row;
        this.number = number;
        vehicleSize = size;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitSpot(Vehicle v) {
        return v.fitSpot(this);
    }

    public boolean parking(Vehicle vehicle) {
        if (isAvailable() && canFitSpot(vehicle)) {
            this.vehicle = vehicle;
            return true;
        }

        return false;
    }

    public void leaving() {
        level.carLeaving();
        vehicle = null;
    }

    public int getRow() {
        return this.row;
    }

    public int getNumber() {
        return this.number;
    }
}