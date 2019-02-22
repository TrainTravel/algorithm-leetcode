package Solution.DynamicProgramming;

/**
 * Given a m x n grid filled with non-negative numbers
 * Find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * i.e., find shortest weight path from top left to bottom right.
 * Note: Only move either down or right at any point in time.
 *
 * @author BorisMirage
 * Time: 2018/08/06 15:46
 * Created with IntelliJ IDEA
 */

public class MinPathSum_64 {
    /**
     * Dynamic programming with table filling.
     * (i,j) = min((i-1, j), (i, j-1)) + grid(i,j)
     * First row and column can be filled at beginning since only one down or right move can be made each time.
     *
     * @param grid input 2D array grid
     * @return min path length from top left to bottom right
     */
    public int minPathSum(int[][] grid) {

        /* First column */
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        /* First line */
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
