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
        if (nums.length < 3) {
            return threeSumResult;
        }

        /* Sort and check */
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return threeSumResult;
        }
        
        HashMap<Integer, Integer> arrayMap = new HashMap<>();

        int bound = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && bound == 0) {
                bound = i;
            }
            /* Hash map key - array value; hash map value - array index */
            arrayMap.put(nums[i], i);
        }

        /* First number index*/
        int i = 0;
        while (i <= bound) {
            if (i != 0) {
                while (nums[i] == nums[i - 1]) {
                    i++;
                    if (i == nums.length - 1) {
                        break;
                    }
                }

            }

            /* Second number index, always started next to i */
            int j = i + 1;

            while (j < nums.length - 1) {

                if (j != i + 1) {
                    while (nums[j] == nums[j - 1]) {
                        j++;
                        if (j == nums.length) {
                            break;
                        }
                    }
                }
                if (j == nums.length) {
                    break;
                }

                /* num[i] is the smallest number in 3 sum numbers */
                int target = -(nums[i] + nums[j]);

                if (arrayMap.containsKey(target) && arrayMap.get(target) > j) {

                    /* If target's index is between i and j, switch them */
                    if (target < nums[j]) {
                        threeSumResult.add(findList(nums[i], target, nums[j]));
                    } else {
                        threeSumResult.add(findList(nums[i], nums[j], target));
                    }
                }
                j++;
            }
            i++;
        }
        return threeSumResult;
    }

    public List<Integer> findList(int a, int b, int c) {
        List<Integer> findList = new LinkedList<>();
        findList.add(a);
        findList.add(b);
        findList.add(c);
        return findList;
    }
}
