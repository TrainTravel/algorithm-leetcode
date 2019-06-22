package Solution.BinarySearch;

/**
 * Suppose an non-empty array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * Assume no duplicate exists in the array.
 *
 * @author BorisMirage
 * Time: 2019/02/20 22:26
 * Created with IntelliJ IDEA
 */

public class FindMin_153 {
    /**
     * Binary search. The minimum element will be at left part, or right part if rotated.
     * There may be a "pivot" in the array lead a reverse, find minimum 2 int in array and finally return minor one.
     *
     * @param nums given int array
     * @return min value in array
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int middle = (left + right) / 2;

            if (nums[middle] > nums[right]) {
                left = middle;      // middle could be min value
            } else {        // nums[right] > nums[middle], left part contains minimum element
                right = middle;     // middle could be min value
            }
        }

        return Math.min(nums[left], nums[right]);
    }

    public static void main(String[] args) {
        FindMin_153 test = new FindMin_153();
        int[] t = {2, 3, 4, 5, 1};
        System.out.println(test.findMin(t));
    }
}
