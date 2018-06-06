package LeetCodeSolution;

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
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumResult = new LinkedList<>();

        /* Special Case */
        if (nums.length < 3) {
            return threeSumResult;
        }

        /* Sort and check */
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return threeSumResult;
        }

        for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {

            /* Avoid duplicate */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] < target) {
                    leftIndex++;
                } else if (nums[leftIndex] + nums[rightIndex] > target) {
                    rightIndex--;
                } else {

                    /* Find one element */
                    List<Integer> findList = new LinkedList<>();
                    findList.add(nums[i]);
                    findList.add(nums[leftIndex]);
                    findList.add(nums[rightIndex]);
                    threeSumResult.add(findList);
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
