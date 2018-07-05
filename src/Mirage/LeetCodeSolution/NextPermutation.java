package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 6/18/18 16:55
 * Created with IntelliJ IDEA
 */

public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such arrangement is not possible, it must rearrange it as the lowest possible order.
     * i.e., sorted in ascending order.
     * The replacement must be in-place and use only constant extra memory.
     *
     * @param nums input int array
     */
    public void nextPermutation(int[] nums) {

        /* Special Case */
        if (nums.length <= 1) {
            return;
        }

        /* Find first element that  nums[i] - nums[i + 1] < 0 */
        int i = nums.length - 2;
        while (i >= 0 && nums[i] - nums[i + 1] >= 0) {
            i--;
        }

        /* Find first element that nums[j] > nums[i] if the whole array is not in decreasing order */
        if (i >= 0) {
            int j = nums.length - 1;

            while (j > 0 && nums[j] - nums[i] <= 0) {
                j--;
            }

            /* Swap these two elements */
            int m = nums[i];
            nums[i] = nums[j];
            nums[j] = m;
        }

        /* Reverse part of int array */
        int a = i + 1;
        int b = nums.length - 1;
        while (a < b) {
            int p = nums[a];
            nums[b] = nums[a];
            nums[a] = p;
            a++;
            b--;
        }
    }
}
