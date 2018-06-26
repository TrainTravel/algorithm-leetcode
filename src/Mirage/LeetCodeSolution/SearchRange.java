package Mirage.LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/19/18
 * Time: 20:58
 */

public class SearchRange {
    /**
     * Given an array of int sorted in ascending order, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     *
     * @param nums input int array
     * @param target target int
     * @return starting and ending position, return [-1, -1] if target is not found
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums.length < 1) {
            return res;
        }

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int mid = (endIndex + startIndex) / 2;

            /* If target found, search all target in array */
            if (nums[mid] == target) {

                /* Search for first index */
                while (mid > 0 && nums[mid - 1] == target) {
                    mid--;
                }
                res[0] = mid;

                /* Search for last index */
                while (mid < nums.length - 1 && nums[mid + 1] == target) {
                    mid++;
                }
                res[1] = mid;
                return res;
            }

            if (target < nums[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return res;
    }
}
