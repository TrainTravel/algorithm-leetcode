package LeetCodeSolution;

import java.util.Arrays;
import java.util.HashMap;
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
        if (nums.length < 2) {
            return threeSumResult;
        }
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                threeSumResult.add(findList(nums[0], nums[1], nums[2]));
                return threeSumResult;
            } else {
                return threeSumResult;
            }
        }
        /* Sort input array */
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return threeSumResult;
        }

        /* Avoid duplicate */
        HashMap<List<Integer>, Integer> findMap = new HashMap<>();
        HashMap<Integer, Integer> arrayMap = new HashMap<>();

        int bound = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && bound == 0) {
                bound = i;
            }
            /* Hash map key - array value; hash map value - array index */
            arrayMap.put(nums[i], i);
        }

        int i = 0;
        while (i <= bound) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);
                if (arrayMap.containsKey(target) && arrayMap.get(target) != i && arrayMap.get(target) != j) {
                    List<Integer> find = findList(nums[i], nums[j], target);
                    if (!findMap.containsKey(find)) {
                        threeSumResult.add(find);
                        findMap.put(find, target);
                    }
                }
            }
            i++;
        }
        return threeSumResult;
    }

    public List<Integer> findList(int a, int b, int c) {
        int[] intArray = {a, b, c};
        Arrays.sort(intArray);
        List<Integer> findList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            findList.add(intArray[i]);
        }
        return findList;
    }
}
