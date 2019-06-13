package Solution.Map;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * It may be assumed that each input would have exactly one solution, and same element can not be used twice.
 *
 * @author BorisMirage
 * Date: 2017/06/17
 * Created with IntelliJ IDEA
 */
public class TwoSum_1 {

    /**
     * Use map to store input and to find out if there exist an number that is target.
     *
     * @param nums   integer number array
     * @param target target sum number
     * @return int array that contains two numbers which sum is target number
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution. \n");
    }

    public static void main(String[] args) {
        TwoSum_1 test = new TwoSum_1();
        int[] testArray = {3, 5, 6, 8, 7};
        int num = 8;
        System.out.println(Arrays.toString(test.twoSum(testArray, num)));
    }
}
