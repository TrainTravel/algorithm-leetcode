package Solution.Heap;

import java.util.*;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Given the locations and height of all the buildings, write a program to output the skyline formed by these buildings collectively.
 * Building is represented by a triplet of integers [Li, Ri, Hi].
 * Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height.
 * It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * Assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * @author BorisMirage
 * Time: 2019/07/19 11:07
 * Created with IntelliJ IDEA
 */

public class GetSkyline_218 {
    /**
     * Use a heap and tree map to sort the given coord.
     *
     * @param buildings given buildings list
     * @return skyline formed by these buildings collectively
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> out = new LinkedList<>();
        List<int[]> height = new LinkedList<>();

        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});     // incomplete height marked as negative
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];     // if position is same, sort by height
                }
                return a[0] - b[0];     // sort the given array by position
            }
        });

        TreeMap<Integer, Integer> tm = new TreeMap<>();     // key: height; value: how many at this height
        int previousHighest = 0;
        tm.put(0, 1);

        for (int[] b : height) {

            if (b[1] < 0) {
                tm.put(-b[1], tm.getOrDefault(-b[1], 0) + 1);
            } else {
                if (tm.get(b[1]) > 1) {
                    tm.put(b[1], tm.get(b[1]) - 1);
                } else {
                    tm.remove(b[1]);
                }
            }
            int currentHighest = tm.lastKey();
            if (currentHighest != previousHighest) {        // if there is a new height
                previousHighest = currentHighest;
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(b[0]);
                temp.add(currentHighest);
                out.add(temp);

//                out.add(new ArrayList<Integer>() {{
//                    add(b[0]);
//                    add(currentHighest);
//                }});
            }
        }

        return out;
    }
}
