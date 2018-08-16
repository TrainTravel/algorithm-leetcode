package Mirage.LeetCodeSolution;

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

public class SearchII {
    /**
     * Simply apply binary search can not solve array with duplicate elements.
     * Hence, narrowing searching range is needed.
     * When sub-array is neither monotonically increasing nor decreasing, narrow search range left and right by one.
     *
     * @param nums   input int array
     * @param target search int
     * @return true if target is in nums, otherwise return false
     */
    public boolean searchII(int[] nums, int target) {

        /* Special Case */
        if (nums.length == 0) {
            return false;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }

            /* Monotonically increasing / decreasing */
            if (nums[mid] < nums[r] || nums[mid] < nums[l]) {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > nums[l] || nums[mid] > nums[r]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {

                /* If the array is neither increasing nor decreasing, then simply narrow the range of searching */
                r--;
                l++;
            }
        }
        return nums[l] == target;
    }
}

