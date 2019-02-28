package Solution.DynamicProgramming;

/**
 * Given a list of non-negative integers array.
 * Note that this time, first element and last element is considered as "adjacent".
 * Determine the maximum sum, that each element consist the sum is not adjacent in given array.
 *
 * @author BorisMirage
 * Time: 2019/02/27 23:24
 * Created with IntelliJ IDEA
 */

public class Rob_213 {
    /**
     * If choose first element, then last element can be regarded as "removed".
     * Last element is same.
     * Therefore, dp(i, j) = max(dp(i, j - 1), dp(i + 1, j))
     * Simply compare the result of array without first element and array without last element.
     *
     * @param nums given array
     * @return maximum sum that is made up by nonadjacent elements
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(range(nums, 0, nums.length - 2), range(nums, 1, nums.length - 1));
    }

    /**
     * Helper function that remove the constrain of first and last element is "adjacent".
     * Note that it will return 0 if input array is empty, or even with negative input.
     * The reason is that the result int is initialized to 0, and the given array is non-negative int array.
     *
     * @param num nums given array
     * @param l   first index of array
     * @param h   second index of array
     * @return maximum sum that is made up by nonadjacent elements
     */
    private int range(int[] num, int l, int h) {
        int a = 0, b = 0;
        for (int i = l; i <= h; i++) {

            int t = b;
            b = Math.max(a + num[i], b);
            a = t;

        }
        return Math.max(a, b);
    }
}
