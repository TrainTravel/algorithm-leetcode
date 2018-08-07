package Mirage.LeetCodeSolution;

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

public class MinPathSum {
    /**
     * Dynamic programming.
     *
     * @param grid input 2D array grid
     * @return min path length from top left to bottom right
     */
    public int minPathSum(int[][] grid) {
        int[][] store = new int[grid.length][grid[0].length];

        store[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            store[i][0] = store[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            store[0][i] = store[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < store.length; i++) {
            for (int j = 1; j < store[0].length; j++) {
                store[i][j] = Math.min(store[i - 1][j], store[i][j - 1]) + grid[i][j];
            }
        }
//        System.out.println(Arrays.deepToString(store));
        return store[store.length - 1][store[0].length - 1];
    }
}