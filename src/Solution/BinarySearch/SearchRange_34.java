package Solution.BinarySearch;

import java.util.Arrays;

/**
 * Given an array of int sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * @author BorisMirage
 * Time: 2018/06/19 20:58
 * Created with IntelliJ IDEA
 */

public class SearchRange_34 {
    /**
     * Normal binary search problem.
     * After the target is found, search left and right of target position to find range.
     *
     * @param nums   input int array
     * @param target target int
     * @return starting and ending position, return [-1, -1] if target is not found
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        /* Corner case */
        if (nums.length < 1) {
            return res;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = (right + left) / 2;

            if (nums[mid] == target) {

                /* Find all elements same as target */
                while (mid > 0 && nums[mid - 1] == target) {
                    mid--;
                }
                res[0] = mid;
                while (mid < nums.length - 1 && nums[mid + 1] == target) {
                    mid++;
                }
                res[1] = mid;
                return res;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        /* Search Range */
        SearchRange_34 searchRangeTest = new SearchRange_34();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 8, 9, 12, 30};
        System.out.println(Arrays.toString(searchRangeTest.searchRange(nums, 4)));
    }
}
