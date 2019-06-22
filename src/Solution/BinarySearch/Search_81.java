package Solution.BinarySearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [5,6,0,0,1,2,2]).
 * A target value is given to search.
 * If found in the array return true, otherwise return false.
 *
 * @author BorisMirage
 * Time: 2018/08/15 15:42
 * Created with IntelliJ IDEA
 */

public class Search_81 {
    /**
     * Simply apply binary search can not solve array with duplicate elements.
     * Hence, narrowing searching range is needed.
     * When sub-array is neither monotonically increasing nor decreasing, narrow search range left and right by one.
     *
     * @param nums   input int array
     * @param target search int
     * @return true if target is in nums, otherwise return false
     */
    public boolean search(int[] nums, int target) {

        /* Corner case */
        if (nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }

            /* Monotonically increasing / decreasing */
            if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {

                /* If the array is neither increasing nor decreasing, then simply narrow the range of searching */
                right--;
                left++;
            }
        }
        return nums[left] == target;
    }
}

