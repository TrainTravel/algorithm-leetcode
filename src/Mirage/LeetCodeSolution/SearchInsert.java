package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 6/21/18 11:14
 * Created with IntelliJ IDEA
 */

public class SearchInsert {
    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * No duplication in the array.
     *
     * @param nums   input int array
     * @param target target int
     * @return insert position
     */
    public int searchInsert(int[] nums, int target) {

        /* Special Case */
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        /* Normal binary search */
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        /* If target was not found in array, return insert position */
        int mid = (left + right) / 2;
        if (target == nums[left]) {
            return left;
        } else if (target > nums[mid]) {
            return mid+ 1;
        } else {
            return mid;
        }
    }
}
