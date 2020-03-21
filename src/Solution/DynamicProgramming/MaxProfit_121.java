package Solution.DynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock)
 * Design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * @author BorisMirage
 * Time: 2019/01/22 11:02
 * Created with IntelliJ IDEA
 */

public class MaxProfit_121 {
    /**
     * Dynamic programming.
     * Similar to max subarray problem.
     *
     * @param prices int array
     * @return max "profit"
     */
    public int maxProfit(int[] prices) {

        /* Corner case */
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = prices[0], n = prices.length;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);                 // min buying price
            dp[i] = Math.max(dp[i - 1], prices[i] + min);
        }

        return dp[n - 1];
    }

    /**
     * Greedy.
     *
     * @param prices int array
     * @return max "profit"
     */
    public int maxProfitGreedy(int[] prices) {
        int max = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(0, prices[i] - prices[i - 1] + profit);
            max = Math.max(max, profit);
        }

        return max;
    }
}
