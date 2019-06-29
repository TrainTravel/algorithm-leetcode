package Solution.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of DISTINCT integers, return all possible permutations.
 *
 * @author BorisMirage
 * Time: 2018/06/24 15:15
 * Created with IntelliJ IDEA
 */

public class Permute_46 {
    /**
     * Use backtracking to traverse each possibility.
     *
     * @param nums input array
     * @return all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        /* Corner case */
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), res);

        return res;
    }

    /**
     * Backtracking to find all possible permutations.
     * The end point is when current temporary list has reached the size of given array.
     *
     * @param nums  given array
     * @param cache temporary list
     * @param res   output list
     */
    private void backtracking(int[] nums, List<Integer> cache, List<List<Integer>> res) {
        if (cache.size() == nums.length) {
            res.add(new ArrayList<>(cache));
        } else {

            /* Traverse elements in array */
            for (int num : nums) {
                if (!cache.contains(num)) {
                    cache.add(num);
                    backtracking(nums, cache, res);
                    cache.remove(cache.size() - 1);
                }
            }
        }
    }
}