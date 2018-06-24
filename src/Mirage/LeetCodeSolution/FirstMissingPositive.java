package Mirage.LeetCodeSolution;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/23/18
 * Time: 20:35
 */

public class FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     * <p>
     * Note:
     * Your algorithm should run in O(n) time and uses constant extra space.
     * <p>
     * Use swapping to switch elements.
     *
     * @param nums input int array
     * @return smallest missing positive int
     */
    public int firstMissingPositive(int[] nums) {

        /* Special Case */
        if (nums.length == 0) {
            return 1;
        }

        int c = 0;


        while (c < nums.length) {
            if (nums[c] > 0 && nums[c] < nums.length && nums[nums[c] - 1] != nums[c] - 1) {
                int temp = nums[nums[c] - 1];
                nums[nums[c] - 1] = nums[c];
                nums[c] = temp;
            } else {
                c++;
            }
        }
        System.out.println(Arrays.toString(nums));

//        for (int i = 0; i < nums.length; i++) {
//
//            /* Condition:
//             *  1. nums[i] > 0: positive number
//             *  2. nums[i] - 1 < nums.length: in index range of nums
//             *  3. nums[nums[i] - 1] != nums[i]: avoid duplicate swapping
//             *  4. nums[i] - 1 != i: avoid swap itself
//             *  Use while loop to find correct number or other int that is longer than nums.length - 1 (if exist)*/
//            while (nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i] && nums[i] - 1 != i) {
//                int temp = nums[nums[i] - 1];
//                nums[nums[i] - 1] = nums[i];
//                nums[i] = temp;
//            }
//        }
        int i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }
}
