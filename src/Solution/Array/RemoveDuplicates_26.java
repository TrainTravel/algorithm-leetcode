package Solution.Array;

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
 * @author BorisMirage
 * Time: 2018/06/13 18:00
 * Created with IntelliJ IDEA
 */

public class RemoveDuplicates_26 {
    /**
     * Two int as pointers.
     * First pointer is the "i" in for loop. It represent the position in traverse.
     * The other pointer points to the last element in array that is non-duplicate.
     * When more than 2 same int is found, the second pointer stop moving until next non-duplicate int is found.
     * Then next element in nums is that non-duplicate int.
     *
     * @param nums input sorted int array
     * @return length of array that removed duplicate element
     */
    public int removeDuplicates(int[] nums) {

        /* Non-duplicate int pointer */
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {

                /* Switch array elements so that this array can be divided in the end */
                nums[n++] = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return n;
    }

    public static void main(String[] args) {

        /* RemoveDuplicates_26 Test */
        RemoveDuplicates_26 removeDuplicatesTest = new RemoveDuplicates_26();
        int[] test = {1, 2, 3, 4};
        System.out.println(removeDuplicatesTest.removeDuplicates(test));
    }
}