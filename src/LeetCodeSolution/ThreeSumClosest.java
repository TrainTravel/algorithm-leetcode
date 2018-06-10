package LeetCodeSolution;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/10/18
 * Time: 17:46
 */

public class ThreeSumClosest {
    /**
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     *
     * @param nums   input numbers
     * @param target target number
     * @return the SUM that is closest to target
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int resultSum = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            /* Avoid duplicate */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int find = target - nums[i];

            /* Include all possible elements (i + 1 to last) */
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {

                /* If current distance is smaller than previous one, switch the sum and distance */
                if (Math.abs(nums[leftIndex] + nums[rightIndex] + nums[i] - target) < minDistance) {
                    resultSum = nums[leftIndex] + nums[rightIndex] + nums[i];
                    minDistance = Math.abs(nums[leftIndex] + nums[rightIndex] + nums[i] - target);
                }

                /* If sum > target, narrow left index (increase sum); otherwise, narrow right index */
                if (nums[leftIndex] + nums[rightIndex] < find) {
                    leftIndex++;
                } else if (nums[leftIndex] + nums[rightIndex] > find) {
                    rightIndex--;
                } else {
                    return nums[leftIndex] + nums[rightIndex] + nums[i];
                }
            }
        }
        return resultSum;
    }
}
