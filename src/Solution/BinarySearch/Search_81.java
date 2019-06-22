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
     * Time complexity: Worst case O(n).
     *
     * @param nums   input int array
     * @param target search int
     * @return true if target is in nums, otherwise return false
     */
    public boolean search(int[] nums, int target) {

        /* Corner case */
        if (nums.length < 1) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            while (left < right && nums[left] == nums[right]) {     // avoid duplicated
                left++;
            }
            int mid = (left + right) / 2;

            if (nums[mid] == target) {      // after excludes duplicated elements, it is same as rotated ascending array
                return true;
            } else if (nums[mid] >= nums[left]) {       // left part
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        /*
         * Check if last element in array is target.
         * If left is larger than array length, then target is not possible in array.
         * */
        return (left != nums.length) && nums[left] == target;
    }

    public static void main(String[] args) {
        Search_81 test = new Search_81();
        System.out.println(test.search(new int[]{1, 1}, 0));

        System.out.println(test.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(test.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(test.search(new int[]{0}, 0));
        System.out.println(test.search(new int[]{0, 0, 0}, 0));
        System.out.println(test.search(new int[]{0, 1, 2, 3, 4, 5, 90}, 0));
        System.out.println(test.search(new int[]{1, 2, 3, 4, 5, 90}, 0));
    }
}
