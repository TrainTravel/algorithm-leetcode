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
     * First, replace all non-positive numbers to array's length.
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

    public static void main(String[] args) {

        /* First Missing Positive */
        FirstMissingPositive firstMissingPositiveTest = new FirstMissingPositive();
        int[] c = {2, 3, 6, 7};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 1
        c = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 2
        c = new int[]{7, 8, 9, 11, 12};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 1
        c = new int[]{1, 2, 0};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 3
        c = new int[]{2, 5, 2, 1, 2, 3};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 4
        c = new int[]{3, 4, 0, 1};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 2
        c = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 8
        c = new int[]{7, 10, 12, 11, 9, 6, 5, 1, 2, 3};
        System.out.println(firstMissingPositiveTest.firstMissingPositive(c));       // 4
    }
}
