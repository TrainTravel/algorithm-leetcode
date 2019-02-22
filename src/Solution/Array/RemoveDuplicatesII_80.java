package Solution.Array;

/**
 * Given a sorted array nums, remove the duplicates in-place.
 * Duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array.
 * It must be done by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Given nums = [1,1,1,2,2,3],
 * Function should return length = 5, with nums being 1, 1, 2, 2 and 3 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * Function should return length = 7, with nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 * @author BorisMirage
 * Time: 2018/08/14 13:49
 * Created with IntelliJ IDEA
 */

public class RemoveDuplicatesII_80 {
    /**
     * Similar to RemoveDuplicates_26, simply modify pointer moving condition.
     * Two int as pointers.
     * First pointer is the "i" in for loop. It represent the position in traverse.
     * The other pointer points to the last element in array that is non-duplicate.
     * When more than 2 same int is found, the second pointer stop moving until next non-duplicate int is found.
     * Then next element in nums is that non-duplicate int.
     *
     * @param nums input sorted int array
     * @return length of array that removed duplicate element
     */
    public int removeDuplicatesII(int[] nums) {

        /* Non-duplicate int pointer */
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[i] > nums[n - 2]) {
                nums[n++] = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return n;
    }
}
