package Mirage.LeetCodeSolution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/4/18
 * Time: 18:11
 */

public class ThreeSum {
    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0.
     * Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Sort the array first, then start from the smallest (or largerest) element.
     * When one element is selected, start from the next element and the last element in this array.
     * Compare the sum of these two elements, if it is smaller than -nums[i], then move the left element to its right.
     * If the sum is larger than 0, then move the right element to its left
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumResult = new LinkedList<>();

        /* If array contains less that 3 elements, directly return empty list */
        if (nums.length < 3) {
            return threeSumResult;
        }

        /* If sorted array's first element > 0 or last element < 0, directly return empty list */
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return threeSumResult;
        }

        for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {

            /* Avoid duplicate */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int find = -nums[i];

            /* Include all possible elements (i + 1 to last) */
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {

                /* If sum > target, narrow left index (increase sum); otherwise, narrow right index */
                if (nums[leftIndex] + nums[rightIndex] < find) {
                    leftIndex++;
                } else if (nums[leftIndex] + nums[rightIndex] > find) {
                    rightIndex--;
                } else {

                    /* Find one */
                    List<Integer> findList = new LinkedList<>();
                    findList.add(nums[i]);
                    findList.add(nums[leftIndex]);
                    findList.add(nums[rightIndex]);
                    threeSumResult.add(findList);

                    /* Keep finding 3sum in this round */
                    leftIndex++;
                    rightIndex--;

                    /* Avoid duplicate */
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                        rightIndex--;
                    }
                }
            }
        }
        return threeSumResult;
    }
}
