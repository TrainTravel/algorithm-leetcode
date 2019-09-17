package OOD.ParkingLot.ParkingSpot;

import OOD.ParkingLot.Vehicle.Vehicle;

/**
 * @author BorisMirage
 * Time: 2019/08/29 18:35
 * Created with IntelliJ IDEA
 */

public class Level {

    protected int row;
    protected int col;
    protected int capacity;
    protected int level;
    protected Spot[][] spots;      // all available spots
    private int available;

    public Level(int row, int column, int level) {
        this.level = level;
        this.row = row;
        this.col = column;
        this.capacity = row * column;
        this.available = capacity;
        // TODO: Init this level

    }

    public boolean parking(Vehicle v) {

        if (available < 1) {
            return false;
        }

        int start = findSpot(v);        // start id
        if (start != -1) {
            startParking(start, v);
        }
        return false;
    }

    public int findSpot(Vehicle v) {
        int findSpotNum;

        for (int i = 0; i < spots.length; i++) {
            findSpotNum = 0;
            for (int j = 0; j < spots.length; j++) {
                if (spots[i][j].vehicleSize == v.getSize() && spots[i][j].isAvailable()) {
                    findSpotNum++;
                }
                if (findSpotNum == v.requiredSpots()) {
                    return i * this.col + j - findSpotNum + 1;
                }
            }
        }

        return -1;
    }

    private void startParking(int start, Vehicle v) {
        int startRow = start / this.row;
        int startCol = start % this.col;
        for (int i = 0; i < v.requiredSpots(); i++) {
            v.parking(spots[startRow][startCol + i]);
            spots[startRow][startCol + i].parking(v);
            capacity--;
        }
    }

    public void carLeaving() {
        available++;
    }
}
