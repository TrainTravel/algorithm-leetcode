package Solution.BinarySearch;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * No duplication in the array.
 *
 * @author BorisMirage
 * Time: 2018/06/21 11:14
 * Created with IntelliJ IDEA
 */

public class SearchInsert_35 {
    /**
     * Binary search.
     *
     * @param nums   input int array
     * @param target target int
     * @return insert position
     */
    public int searchInsert(int[] nums, int target) {

        /* Corner case */
        if (nums.length == 0 || target < nums[0]) {
            return (target > nums[nums.length - 1]) ? nums.length : 0;
        }

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
        return (target == nums[left]) ? left : (target > nums[mid]) ? mid + 1 : mid;
    }

    public static void main(String[] args) {

        SearchInsert_35 searchInsertTest = new SearchInsert_35();
        int[] nums = {1, 3};

        System.out.println(searchInsertTest.searchInsert(nums, 2));
    }
}
