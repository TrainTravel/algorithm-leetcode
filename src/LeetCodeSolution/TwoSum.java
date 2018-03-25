package LeetCodeSolution;

import java.util.HashMap;

/**
 * Created by borismirage on 2017/6/17.
 */
class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> arrayMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (arrayMap.containsKey(target - nums[i])){
                return new int[] {i, arrayMap.get(target - nums[i])};
            }
            arrayMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution. \n");
    }

    public static void main(String[] args) {
    }
}
