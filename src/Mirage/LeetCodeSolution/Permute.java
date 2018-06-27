package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/24/18
 * Time: 15:15
 */

public class Permute {
    /**
     * Given a collection of DISTINCT integers, return all possible permutations.
     * <p>
     * Backtracking.
     *
     * @param nums input array
     * @return all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        /* Special Case */
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), res);

        return res;
    }

    private void backtracking(int[] nums, List<Integer> cache, List<List<Integer>> res) {
        if (cache.size() == nums.length) {
            res.add(new ArrayList<>(cache));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!cache.contains(nums[i])) {
                    cache.add(nums[i]);
                    backtracking(nums, cache, res);
                    cache.remove(cache.size() - 1);
                }
            }
        }
    }
}