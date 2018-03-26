package LeetCodeSolution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by borismirage on 2017/6/17.
 */
public class TwoSum {

    /** Find if there are two numbers in array that their sum is target number
     * @param nums integer number array
     * @param target target sum number
     * @return int array that contains two numbers which sum is target number
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> arrayMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (arrayMap.containsKey(target - nums[i])) {
                return new int[]{i, arrayMap.get(target - nums[i])};
            }
            arrayMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution. \n");
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] testArray = {3, 5, 6, 8, 7};
        int num = 8;
        System.out.println(Arrays.toString(test.twoSum(testArray, num)));
    }
}
