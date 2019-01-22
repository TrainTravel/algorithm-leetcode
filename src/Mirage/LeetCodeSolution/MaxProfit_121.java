package Mirage.LeetCodeSolution;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7 - 1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author BorisMirage
 * Time: 2019/01/22 11:02
 * Created with IntelliJ IDEA
 */

public class MaxProfit_121 {
    /**
     * Dynamic programming. Similiar to max subarray problem.
     *
     * @param prices int array
     * @return max "profit"
     */
    public int maxProfit(int[] prices) {

        int current = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {

            /* Avoid negative */
            current = Math.max(0, current + prices[i] - prices[i - 1]);
            max = Math.max(current, max);
        }
        return max;
    }
}
