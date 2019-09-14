package Solution.DynamicProgramming;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * Find the minimum cost to paint all houses.
 * Note:
 * All costs are positive integers.
 *
 * @author BorisMirage
 * Time: 2019/09/14 09:49
 * Created with IntelliJ IDEA
 */

public class MinCost_256 {
    /**
     * Dynamic programming.
     * State transition:
     * dp[i][j] = min(dp[i - 1][k]), where k != j
     *
     * @param costs cost of painting
     * @return minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {

        /* Corner case */
        if (costs.length == 0) {
            return 0;
        }

        int colors = 3;

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < colors; j++) {
                int tmp = Integer.MAX_VALUE;
                for (int k = 0; k < colors; k++) {
                    if (k != j) {
                        tmp = Math.min(costs[i - 1][k], tmp);
                    }
                }
                costs[i][j] += tmp;
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < costs[0].length; i++) {
            min = Math.min(costs[colors - 1][i], min);
        }

        return min;
    }
}
