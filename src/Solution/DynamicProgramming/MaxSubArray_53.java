package Solution.DynamicProgramming;


/**
 * Given an integer array nums
 * Find the contiguous sub array (containing at least one number) which has the largest sum and return its sum.
 *
 * @author BorisMirage
 * Time: 2018/06/29 19:34
 * Created with IntelliJ IDEA
 */

public class MaxSubArray_53 {
    /**
     * Basic dynamic programming.
     * dp[i] = dp[i - 1] + nums[i], if dp[i - 1] + dp[i] > 0
     * dp[i] = nums[i], otherwise
     * max = Math.max(dp[i], max)
     *
     * @param nums input int array
     * @return max contiguous sub array sum
     */
    public int maxSubArray(int[] nums) {

        /* Corner case*/
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] + dp[i] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);

        }
        return max;
    }
}
