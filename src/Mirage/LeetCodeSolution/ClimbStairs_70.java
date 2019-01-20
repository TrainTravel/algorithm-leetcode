package Mirage.LeetCodeSolution;

/**
 * It takes n steps from bottom to reach to the top.
 * Each time climb 1 or 2 steps can be made.
 * Find how many distinct ways to reach the top.
 * Note: Given n will be a positive integer.
 *
 * @author BorisMirage
 * Time: 2018/08/07 15:23
 * Created with IntelliJ IDEA
 */

public class ClimbStairs_70 {
    /**
     * Dynamic programming.
     * Create a new array that store current n length paths.
     * arr[i] = arr[i - 1] + arr[i - 2]
     *
     * @param n n steps to reach the top
     * @return num of paths
     */
    public int climbStairs(int n) {
        int[] res = new int[n + 2];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i < n + 2; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n + 1];
    }
}
