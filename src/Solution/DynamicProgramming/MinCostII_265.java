package Solution.DynamicProgramming;

/**
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * Find the minimum cost to paint all houses.
 * Note:
 * All costs are positive integers.
 *
 * @author BorisMirage
 * Time: 2019/09/14 09:39
 * Created with IntelliJ IDEA
 */

public class MinCostII_265 {
    /**
     * Naive dynamic programming.
     * State transition:
     * dp[i][j] = min(dp[i - 1][k]), where k != j
     * Time complexity: O(n * k ^ 2)
     *
     * @param costs cost of painting
     * @return minimum cost to paint all houses
     */
    public int naiveDP(int[][] costs) {

        /* Corner case */
        if (costs.length == 0) {
            return 0;
        }

        int colors = costs.length, min;
        int[][] dp = new int[costs.length][costs[0].length];        // do not modify input
        dp[0] = costs[0];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                min = Integer.MAX_VALUE;

                for (int k = 0; k < costs[0].length; k++) {
                    if (k != j) {
                        min = Math.min(dp[i - 1][k] + costs[i][j], min);
                    }
                }

                dp[i][j] = min;
            }
        }

        min = Integer.MAX_VALUE;

        for (int i = 0; i < costs[0].length; i++) {     // find min value in last row
            min = Math.min(dp[colors - 1][i], min);
        }

        return min;
    }
}
