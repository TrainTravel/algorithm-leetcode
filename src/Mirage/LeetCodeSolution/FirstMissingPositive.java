package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 2018/06/23 20:35
 * Created with IntelliJ IDEA
 */

public class FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     * <p>
     * Note:
     * Algorithm should run in O(n) time and uses constant extra space.
     * <p>
     * Traverse array three times.
     * First, replace all non-negative numbers to array's length.
     * In second traversal, find nums[i] that absolute value is smaller than array's length.
     * Mark its representative index's value to negative.
     * i.e, abs(nums[i])=5, then nums[4] = - nums[4]
     * The reason to use absolute value is to save while loop compare to swapping method.
     *
     * @param nums input int array
     * @return smallest missing positive int
     */
    public int firstMissingPositive(int[] nums) {

        /* Special Case */
        if (nums.length == 0) {
            return 1;
        }

        /* Remove all negative elements */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        /* Mark each element that is smaller than length of array to negative value
         * To avoid unnecessary move in swapping, use absolute value and mark respective position in negative number */
        for (int i = 0; i < nums.length; ++i) {
            if (Math.abs(nums[i]) <= nums.length) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }

        /* Finally, traverse array and return first positive index, which is first missing positive number */
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
