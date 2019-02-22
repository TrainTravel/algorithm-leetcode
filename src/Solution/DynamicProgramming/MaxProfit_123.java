package Solution.DynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * @author BorisMirage
 * Time: 2019/01/22 21:14
 * Created with IntelliJ IDEA
 */

public class MaxProfit_123 {

    /**
     * Add a second sell to compare.
     *
     * @param prices price int array
     * @return max profit
     */
    public int maxProfit(int[] prices) {

        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = buy1, sell2 = 0;        // sell2 presume second time sell

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);      // at least sell one time (if no profit then it keeps 0)
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);      // compare if there is second buy & sell
        }

        return sell2;
    }
}
