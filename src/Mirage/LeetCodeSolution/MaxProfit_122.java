package Mirage.LeetCodeSolution;

/**
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * @author BorisMirage
 * Time: 2019/01/22 18:44
 * Created with IntelliJ IDEA
 */

public class MaxProfit_122 {
    /**
     * Ignore this problem.
     *
     * @param prices int arr
     * @return max profit
     */
    public int maxProfit(int[] prices) {
        int t = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                t += prices[i] - prices[i - 1];
            }
        }
        return t;
    }
}
