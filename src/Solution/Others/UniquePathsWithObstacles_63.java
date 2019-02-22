package Solution.Others;

/**
 * From top-left corner to bottom-right of a m x n grid .
 * In each move, only either down or right at any point can be made.
 * There may be obstacle in grid, hence it is possible that bottom-right can not be reached.
 * Find total number of possible unique paths.
 *
 * @author BorisMirage
 * Time: 2018/08/03 13:25
 * Created with IntelliJ IDEA
 */

public class UniquePathsWithObstacles_63 {
    /**
     * Similar to find path without obstacle.
     * The only difference is that when searching path the block with obstacle needs to be excluded.
     * Use a new int array to record path number since the obstacle exists.
     * Fill each grid row, simply check left block of current block, if there is obstacle at left, set 0.
     *
     * @param obstacleGrid input grid with obstacle
     * @return total paths number
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];

        /* Set Start */
        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
