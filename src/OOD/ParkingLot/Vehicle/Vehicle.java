package OOD.ParkingLot.Vehicle;

import OOD.ParkingLot.ParkingSpot.Spot;

import java.util.ArrayList;

/**
 * @author BorisMirage
 * Time: 2019/08/29 17:57
 * Created with IntelliJ IDEA
 */

public abstract class Vehicle {


    protected VehicleSize size;
    protected String license;
    protected int requiredSpots;        // bus takes 5 consecutive spots

    protected ArrayList<Spot> arr = new ArrayList<>();       // for bus, or any vehicle takes more than 1 spot

    public VehicleSize getSize() {
        return size;
    }

    public int requiredSpots() {
        return requiredSpots;
    }

    public void parking(Spot p) {
        arr.add(p);
    }

    public void cleanSpot() {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).leaving();       // call spot for cleaning
        }

        arr.clear();
    }

    public abstract boolean fitSpot(Spot s);

    public abstract void log();
}

