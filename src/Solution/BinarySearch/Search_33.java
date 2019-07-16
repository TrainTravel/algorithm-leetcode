package Solution.BinarySearch;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Algorithm's runtime complexity must be in the order of O(log n).
 *
 * @author BorisMirage
 * Time: 2018/06/19 15:57
 * Created with IntelliJ IDEA
 */

public class Search_33 {
    /**
     * Use modified binary search.
     * Only one sub-array in each search will possibly not be in ascending order.
     * Hence, in each binary search iteration, identify sub-array that is not in ascending order.
     * If target is not in normal ascending sub-array, compare target to the rest sub-array's mid and end.
     * If sub-array [mid, end] is normal array, compare target to this array to see if in this range.
     * Repeat this process until no sub-array to search or found target.
     *
     * @param nums   input int array
     * @param target value to search
     * @return target index in array
     */
    public int search(int[] nums, int target) {

        /* Corner case */
        if (nums.length < 1) {
            return -1;
        }

        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {     // avoid corner case that target is at left most of array

            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {      // left sub-array is normal ascending array, and including array with 2 elements

                if (target < nums[mid] && target >= nums[left]) {       // nums[left] <= target <  nums[mid]
                    right = mid - 1;        // target is in the left sub-array
                } else {        // target < left => right subarray is rotated, target > mid => right subarray
                    left = mid + 1;
                }
            } else {        // nums[left] > nums[mid] => rotated pivot in left subarray

                if (target <= nums[right] && target > nums[mid]) {      // nums[mid] < target <= nums[right]
                    left = mid + 1;     // normal situation, target at right subarray
                } else {        // otherwise, target is in right subarray
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Search_33 searchTest = new Search_33();
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(searchTest.search(nums, 4));
    }
}
