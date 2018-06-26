package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/24/18
 * Time: 16:36
 */

public class PermuteUnique {
    /**
     * Given a collection of numbers that might contain duplicates, return all possible UNIQUE permutations.
     * <p>
     * Backtracking.
     * The difference between permute problem is that one boolean array is added during backtracking process.
     * This boolean array is to record if current element is used (for uniqueness).
     *
     * @param nums input number collection
     * @return all possible unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;

    }

    private void backtracking(int[] nums, List<Integer> cache, List<List<Integer>> res, boolean[] use) {

        /* Exit point */
        if (cache.size() == nums.length) {
            res.add(new ArrayList<>(cache));
        } else {
            for (int i = 0; i < nums.length; i++) {

                /* Avoid reuse element in array */
                if (use[i] || i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) {
                    continue;
                }

                /* Add element to list and mark current element as used */
                cache.add(nums[i]);
                use[i] = true;
                backtracking(nums, cache, res, use);
                use[i] = false;
                cache.remove(cache.size() - 1);
            }
        }
    }
}
