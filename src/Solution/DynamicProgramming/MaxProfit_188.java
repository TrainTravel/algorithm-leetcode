package Solution.DynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * @author BorisMirage
 * Time: 2019/01/31 21:54
 * Created with IntelliJ IDEA
 */

public class MaxProfit_188 {
    /**
     * Dynamic programming with 2D table.
     * dp[i, j] = max(dp[i, j - 1], prices[j] - prices[m] + dp[i - 1, m])
     * i: ith transaction
     * j: prices[j], index in int array price
     * m: in range of [0, j-1]
     * => [i, j] = max([i, j - 1], prices[j] + max([i - 1, m] - prices[m]))  (efficient for looping)
     * Base case:
     * dp[0, j] = 0
     * dp[i, 0] = 0
     *
     * @param k      at most k transactions
     * @param prices int array
     * @return max profit
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        /* Corner case */
        if (n < 2) {
            return 0;
        }

        if (k >= n / 2) {       // k is sufficient for comparing each adjacent value in array
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {        // buy and sell
            int max = -prices[0];
            for (int j = 1; j < n; j++) {     // stock prices

                dp[i][j] = Math.max(prices[j] + max, dp[i][j - 1]);     // sell with highest price
                max = Math.max(dp[i - 1][j] - prices[j], max);          // buy with lowest price
            }
        }

        return dp[k][n - 1];
    }

    /**
     * DP solution with space optimized.
     *
     * @param k      k times transaction limit
     * @param prices prices array
     * @return max profit from the array
     */
    public int dpOptimized(int k, int[] prices) {

        /* Corner case */
        if (prices.length < 2) {
            return 0;
        }

        if (k >= prices.length / 2) {       // k is sufficient for comparing each adjacent value in array
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        int[] r1 = new int[prices.length];
        int[] r2 = new int[prices.length];

        for (int i = 1; i < k + 1; i++) {
            int base = -prices[0];

            for (int j = 1; j < r1.length; j++) {
                r2[j] = Math.max(r2[j - 1], prices[j] + base);
                base = Math.max(base, r1[j] - prices[j]);
            }

            for (int j = 0; j < prices.length; j++) {       // mem compress
                r1[j] = r2[j];
                r2[j] = 0;
            }
        }

        return r1[prices.length - 1];
    }

    /**
     * Use a state machine to save state.
     * The length of state is 2 * k, since each k representing a buy and sell state.
     *
     * @param k      at most k transactions
     * @param prices given int array
     * @return max profit
     */
    public int stateMachine(int k, int[] prices) {

        /* Corner case */
        if (k == 0 || prices.length < 2) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        int[] state = new int[k * 2];
        state[0] = -prices[0];
        for (int i = 1; i < state.length; i++) {
            state[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < state.length; j++) {

                /* State transition */
                if (j == 0) {
                    state[j] = Integer.max(state[j], -prices[i]);
                } else {
                    state[j] = Integer.max(state[j], (j % 2 == 0 ? state[j - 1] - prices[i] : state[j - 1] + prices[i]));
                }
            }
        }

        return Math.max(0, state[state.length - 1]);
    }
}
