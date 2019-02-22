package Solution.DynamicProgramming;


/**
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note:
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * Input: [3,1,5,8]
 * Output: 167
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author BorisMirage
 * Time: 2018/09/23 16:26
 * Created with IntelliJ IDEA
 */

public class MaxCoins_312 {
    /**
     * This problem can be solved by dynamic programming.
     * However, it can be easier understood by using divide and conquer with memoization.
     * This solution use recursion to construct a table from 1 to n.
     *
     * @param nums input int array
     * @return max score
     */
    public int maxCoins(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] coins = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            coins[i + 1] = nums[i];
        }
        coins[0] = coins[coins.length - 1] = 1;

        return findMax(new int[coins.length][coins.length], coins, 0, coins.length - 1);
    }

    private int findMax(int[][] mem, int[] coins, int left, int right) {
        if (left + 1 == right) {
            return 0;       // Out of boundary
        }
        if (mem[left][right] > 0) {
            return mem[left][right];        // Return current max
        }
        int maxCoins = 0;

        for (int i = left + 1; i < right; ++i) {
            maxCoins = Math.max(coins[i] * coins[left] * coins[right] + findMax(mem, coins, left, i) + findMax(mem, coins, i, right), maxCoins);
        }
        mem[left][right] = maxCoins;
        return maxCoins;

    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        MaxCoins_312 test = new MaxCoins_312();
        System.out.println(test.maxCoins(arr));
    }


}
