package Mirage.LeetCodeSolution;

/**
 * From top-left corner to bottom right of a m x n grid .
 * In each move, only either down or right at any point can be made.
 * Find total number of possible unique paths.
 *
 * @author BorisMirage
 * Time: 2018/08/03 12:37
 * Created with IntelliJ IDEA
 */

public class UniquePaths_62 {
    /**
     * Find total paths via fill m x n table.
     * If block is in first row or first column, fill 1.
     * Otherwise, fill the sum of left block and upper block.
     * Start point: (0,0)
     * End point: (m-1, n-1)
     *
     * @param m m rows
     * @param n n columns
     * @return total number of path
     */
    public int uniquePaths(int m, int n) {

        /* Special Case */
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }
}
