package Mirage.LeetCodeSolution;

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

public class Search {
    /**
     * Use modified binary search. Only one sub-array in each search will possibly not be in ascending order.
     * Hence, in each binary search iteration, find sub-array that is not in ascending order.
     * If target is not in normal ascending sub-array, compare target to the rest sub-array's mid and end.
     * If sub-array [mid, end] is normal array, compare target to this array to see if in this range.
     * Repeat this process until no sub-array to search or found target.
     *
     * @param nums   input int array
     * @param target value to search
     * @return target index in array
     */
    public int search(int[] nums, int target) {

        /* Special Case */
        if (nums.length < 1) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            int mid = (endIndex + startIndex) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            /* If left sub-array is normal ascending array */
            if (nums[startIndex] <= nums[mid]) {

                /* If target is in the range, search this part */
                if (target < nums[mid] && target >= nums[startIndex]) {
                    endIndex = mid - 1;
                } else {

                    /* If target is not in this part, search right part */
                    startIndex = mid + 1;
                }
            } else {

                /* Find the normal ascending part and continue search as above */
                if (target <= nums[endIndex] && target > nums[mid]) {
                    startIndex = mid + 1;
                } else {
                    endIndex = mid - 1;
                }
            }

        }

        /* mid has been compare to target during the iteration, hence first element needs to compare to target here */
        if (nums[startIndex] == target) {
            return startIndex;
        }
        return -1;
    }

    public static void main(String[] args) {

        /* Search */
        Search searchTest = new Search();
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(searchTest.search(nums, 4));
    }
}
