package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 2018/06/13 18:00
 * Created with IntelliJ IDEA
 */

public class RemoveDuplicates {
    /**
     * Given a sorted array nums.
     * Remove the duplicates in-place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array.
     * It must be done by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Note: Input array is passed in by reference, modification to it will be known to the caller as well.
     * Output sample:
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeElement(nums, val);
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
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {

                /* Switch array elements so that this array can be divided in the end */
                nums[length++] = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return length;
    }
}