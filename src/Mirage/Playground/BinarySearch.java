package Mirage.Playground;


/**
 * Created with IntelliJ IDEA
 * @author BorisMirage
 * Date: 2/25/18
 * Time: 14:38
 */

public class BinarySearch {
    private int[] searchArray;
    private int target;
    private int res;

    /**
     * Complete a binary search in a sorted array.
     *
     * @param array input array
     * @param i     int to be found in array
     */
    public BinarySearch(int[] array, int i) {
        searchArray = array;
        target = i;
    }

    public boolean search() {
        if (searchArray.length < 1) {
            return false;
        }
        return find(searchArray.length - 1);
    }

    /**
     * Find target position.
     *
     * @param endIndex search end position
     * @return if found
     */
    private boolean find(int endIndex) {
        int startIndex = 0;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (searchArray[mid] == target) {
                res = mid;
                return true;
            } else if (searchArray[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }

        }
        return false;
    }

    /**
     * Find the target position.
     * If target is not found in array, return -1.
     *
     * @return target position, return -1 if target not found
     */
    public int where() {
        if (find(searchArray.length - 1)) {
            return res;
        } else {
            return -1;
        }
    }
}
