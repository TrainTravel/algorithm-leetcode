package Solution.Matrix;

import java.util.*;

/**
 * A 2D grid of values 0 or 1 is given.
 * Find a point that from all 1 to this point, where the total Manhattan distance is minimized.
 * Manhattan distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * @author BorisMirage
 * Time: 2019/05/05 23:07
 * Created with IntelliJ IDEA
 */

public class MinTotalDistance_296 {
    /**
     * Calculate sum of position in row and column respectively.
     * The way to find a min distance is to find median in row and column to minimize Manhattan distance.
     *
     * @param grid given grid
     * @return minimize Manhattan distance
     */
    public int minTotalDistance(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        List<Integer> row = new ArrayList<>();      // total value in each row
        List<Integer> col = new ArrayList<>();      // total value in each column

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        return minSum(row) + minSum(col);       // convert 2D to 1D
    }

    /**
     * Find min sum in given list
     *
     * @param a list
     * @return minimize sum of given list
     */
    private int minSum(List<Integer> a) {
        int d = 0;
        Collections.sort(a);
        int l = 0;
        int r = a.size() - 1;
        while (l < r) {
            d = d + a.get(r--) - a.get(l++);
        }
        return d;
    }
}
