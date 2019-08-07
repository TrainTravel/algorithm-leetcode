package Solution.Backtracking;

/**
 * Alex and Lee continue their games with piles of stones.
 * There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * The objective of the game is to end with the most stones.
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.
 * Then, we set M = max(M, X).
 * The game continues until all the stones have been taken.
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 *
 * @author BorisMirage
 * Time: 2019/08/03 18:26
 * Created with IntelliJ IDEA
 */

public class StoneGameII_1140 {
    /**
     * Min-max algorithm.
     *
     * @param piles given array represents stone piles
     * @return the maximum number of stones Alex can get
     */
    public int stoneGameII(int[] piles) {

        /* Corner case */
        if (piles.length == 0) {
            return 0;
        }

        int l = piles.length;
        int[] sum = new int[l];
        sum[l - 1] = piles[l - 1];

        for (int i = l - 2; i > -1; i--) {      // sum of rest stones that could be taken in one time
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] dp = new int[l][l];
        return helper(piles, 0, 0, sum, dp);
    }

    private int helper(int[] piles, int i, int m, int[] sum, int[][] dp) {

        if (i == piles.length) {        // reaches the end of piles
            return 0;
        }

        if (m * 2 >= piles.length - i) {        // the other plays can take all rest stones
            return sum[i];
        }

        if (dp[i][m] != 0) {        // use previous memorization
            return dp[i][m];
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= 2 * m; j++) {
            min = Math.min(min, helper(piles, i + j, Math.max(m, j), sum, dp));
        }

        dp[i][m] = sum[i] - min;

        return dp[i][m];
    }
}
