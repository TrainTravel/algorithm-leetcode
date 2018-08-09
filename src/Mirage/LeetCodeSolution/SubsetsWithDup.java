package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BorisMirage
 * Time: 2018/08/09 13:57
 * Created with IntelliJ IDEA
 */

public class SubsetsWithDup {
    /**
     * Use backtracking.
     *
     * @param nums input int array
     * @return List that contains all subsets
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(res, new ArrayList<>(), nums, 0);
        return res;
    }

    /**
     * Basic backtracking.
     *
     * @param res  output List
     * @param temp temp List
     * @param nums int array
     * @param k    each recursion start position
     */
    private void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, int k) {
        res.add(new ArrayList<>(temp));
        for (int i = k; i < nums.length; i++) {

            /* Avoid output duplication */
            if (i > k && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtracking(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
