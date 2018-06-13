package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/13/18
 * Time: 18:00
 */

public class RemoveDuplicates {
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