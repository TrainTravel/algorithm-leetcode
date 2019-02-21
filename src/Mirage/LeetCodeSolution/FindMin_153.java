package Mirage.LeetCodeSolution;

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
     * Binary search.
     * There may be a "pivot" in the array lead a reverse, find minimum 2 int in array and finally return minor one.
     *
     * @param nums given int array
     * @return min value in array
     */
    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right - 1) {

            int m = (right + left) / 2;
            if (nums[m] > nums[right]) {
                left = m;
            } else {
                right = m;
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
