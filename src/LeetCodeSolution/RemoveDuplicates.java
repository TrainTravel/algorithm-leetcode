package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/13/18
 * Time: 18:00
 */

public class RemoveDuplicates {
    /**
     * Given a sorted array nums.
     * Remove the duplicates in-place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array.
     * It must be done by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Note: Input array is passed in by reference, modification to it will be known to the caller as well.
     * <p>
     * Output sample:
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeElement(nums, val);
     * <p>
     * // any modification to nums in your function would be known by the caller.
     * // using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     *
     * @param nums input int sorted array
     * @return length
     */
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        int length = 0;
        for (int i = 0; i < l; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {

                /* Switch array elements so that this array can be divided in the end */
                nums[length++] = nums[i];

            }
        }
        return length;
    }
}