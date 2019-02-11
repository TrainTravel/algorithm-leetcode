package Mirage.LeetCodeSolution;

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
     * Dynamic programming with table.
     * [i, j] = max([i, j - 1], prices[j] - prices[jj] + [i - 1, jj])
     * i: ith transaction
     * j: prices[j], index in int array price
     * jj: in range of [0, j-1]
     * => [i, j] = max(dp[i, j - 1], prices[j] + max(dp[i - 1, jj] - prices[jj]))
     * dp[0, j] = 0
     * dp[i, 0] = 0
     *
     * @param k      at most k transactions
     * @param prices int array
     * @return max profit
     */
    public int maxProfit(int k, int[] prices) {

        if (prices.length < 1) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int temp = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    temp += prices[i] - prices[i - 1];
            }
            return temp;
        }

        int[][] t = new int[k + 1][prices.length];

        for (int i = 1; i < k + 1; i++) {
            int temp = t[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + temp);
                temp = Math.max(temp, t[i - 1][j] - prices[j]);
            }
        }

        return t[k][prices.length - 1];
    }
}
