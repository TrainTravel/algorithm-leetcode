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
     *
     * Note: The duplicated elements should be replace by non-duplicated elements.
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