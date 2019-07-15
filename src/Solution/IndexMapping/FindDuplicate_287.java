package Solution.IndexMapping;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive).
 * Prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * 1. Do not modify the array (assume the array is read only).
 * 2. Use only constant, O(1) extra space.
 * 3. Runtime complexity should be less than O(n2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * @author BorisMirage
 * Time: 2019/07/15 16:28
 * Created with IntelliJ IDEA
 */

public class FindDuplicate_287 {
    /**
     * Index mapping. Mark nums[nums[i]] to negative. If meet any nums[i] that is negative, then the duplicated # is found.
     *
     * @param nums given array
     * @return duplicate number in array
     */
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        return -1;
    }
}
