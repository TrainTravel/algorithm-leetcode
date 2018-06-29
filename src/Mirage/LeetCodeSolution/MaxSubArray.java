package Mirage.LeetCodeSolution;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/29/18
 * Time: 19:34
 */

public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        /* Special Case */
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            maxSum = Integer.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
