package Solution.Array;

/**
 * @author BorisMirage
 * Time: 2018/06/13 22:16
 * Created with IntelliJ IDEA
 */

public class RemoveElement_27 {
    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     * Do not allocate extra space for another array
     * It must be done by modifying the input array in-place with O(1) extra memory.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * <p>
     * Note: Input array is passed in by reference, modification to it will be known to the caller as well.
     * <p>
     * Examples:
     * <p>
     * Given nums = [3,2,2,3], val = 3,
     * Function should return length = 2, with the first two elements of nums being 2.
     * It doesn't matter what to leave beyond the returned length.
     * <p>
     * Given nums = [0,1,2,2,3,0,4,2], val = 2,
     * Function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
     * Note that the order of those five elements can be arbitrary.
     * It doesn't matter what values are set beyond the returned length.
     *
     * Output sample:
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeElement(nums, val);
     *
     * // any modification to nums in your function would be known by the caller.
     * // using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * @param nums input int array
     * @param val  int that will be removed in array
     * @return nums length after this process
     */
    public int removeElement(int[] nums, int val) {

        /* Special case */
        if (nums.length == 0) {
            return 0;
        }

        int length = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (nums[i] != val) {

                nums[length++] = nums[i];

            }
        }
        return length;

    }
}
