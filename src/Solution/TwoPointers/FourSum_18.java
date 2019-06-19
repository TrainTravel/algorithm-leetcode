package Solution.TwoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array and an integer target, find if there exist four elements such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * 1. The solution set must not contain duplicate quadruplets.
 *
 * @author BorisMirage
 * Time: 2018/06/11 19:47
 * Created with IntelliJ IDEA
 */

public class FourSum_18 {
    /**
     * Similar to 3 sum and 3 sum closest, the only difference is to modify the bound when searching array
     *
     * @param nums   input integer array
     * @param target target sum
     * @return linked list that contains all unique quadruplets
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> out = new LinkedList<>();

        /* Corner case */
        if (nums.length < 4) {
            return out;     // if array contains less that 4 elements, directly return empty list
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {     // avoid duplication

                for (int j = i + 1; j < nums.length - 2; j++) {

                    /* 3 Sum problem */
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int sum = target - nums[i] - nums[j];

                        /* Include all possible elements (j + 1 to last) */
                        int leftIndex = j + 1;
                        int rightIndex = nums.length - 1;

                        while (leftIndex < rightIndex) {

                            /* If sum > target, narrow left index (increase sum); otherwise, narrow right index */
                            if (nums[leftIndex] + nums[rightIndex] < sum) {
                                leftIndex++;
                            } else if (nums[leftIndex] + nums[rightIndex] > sum) {
                                rightIndex--;
                            } else {

                                /* Find one */
                                List<Integer> findList = new LinkedList<>();
                                findList.add(nums[i]);
                                findList.add(nums[j]);
                                findList.add(nums[leftIndex]);
                                findList.add(nums[rightIndex]);
                                out.add(findList);

                                /* Keep finding 4sum in this round */
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
                }
            }
        }
        return out;
    }
}
