package Solution.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * @author BorisMirage
 * Time: 2019/06/19 11:07
 * Created with IntelliJ IDEA
 */

public class ThreeSum_15 {
    /**
     * Sort the array first, then start from the smallest (or largest) element.
     * When one element is selected, start from the next element and the last element in this array.
     * Compare the sum of these two elements, if it is smaller than -nums[i], then move the left element to its right.
     * If the sum is larger than 0, then move the right element to its left.
     * Move two pointers toward center.
     *
     * @param nums input array
     * @return list that contain results
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> out = new ArrayList<>();

        /* Corner case */
        if (nums.length < 3) {
            return out;
        }

        Arrays.sort(nums);      // sort array

        /* Corner case */
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return out;     // if all elements are positive, then it is not possible to have a three sum equals 0
        }

        for (int i = 0; nums[i] < 1 && i < nums.length - 2; i++) {      // if current value > 0, then no possible triplet exists

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;       // avoid duplicate
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {      // move two points toward center

                if (nums[left] + nums[right] < -nums[i]) {
                    left++;     // make sum larger
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;        // make sum smaller
                } else {

                    /* Find one triplet */
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    out.add(temp);
                    left++;
                    right--;

                    /* Avoid duplicate */
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {

        /* Three sum test*/
        int[] test = {0, -4, -1, -4, -2, -3, 2};
        ThreeSum_15 threeSumTest = new ThreeSum_15();
        System.out.println(threeSumTest.threeSum(test));
    }
}
