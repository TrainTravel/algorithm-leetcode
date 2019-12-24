package Solution.BinarySearch;

/**
 * Given a ascending order integer array nums of n elements and a target value.
 * Search target in nums.
 * If target exists, then return its index, otherwise return -1.
 *
 * @author BorisMirage
 * Time: 2019/06/02 23:37
 * Created with IntelliJ IDEA
 */

public class Search_704 {
    /**
     * Basic binary search.
     *
     * @param nums   given array
     * @param target target number
     * @return if target exists, return its index, otherwise return -1
     */
    public int search(int[] nums, int target) {

        /* Corner case */
        if (nums.length < 1) {
            return -1;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) >>> 1;      //  right shift 1 bit, equals divide 2
            if (target == nums[m]) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
