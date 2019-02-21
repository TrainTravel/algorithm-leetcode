package Mirage.LeetCodeSolution;

/**
 * Given an array with n objects colored red, white or blue.
 * Sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: Do not use the library's sort function for this problem.
 *
 * @author BorisMirage
 * Time: 2018/08/08 20:45
 * Created with IntelliJ IDEA
 */

public class SortColors_75 {
    /**
     * Two pointers.
     *
     * @param nums input array
     */
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0 && i != l) {
                swap(nums, l, i);
                l++;
                i--;
            } else if (nums[i] == 2 && i != r) {
                swap(nums, r, i);
                r--;
                i--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
