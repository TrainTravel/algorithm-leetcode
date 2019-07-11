package Solution.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a array of integers that might contain duplicates int.
 * Return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author BorisMirage
 * Time: 2018/08/09 13:57
 * Created with IntelliJ IDEA
 */

public class SubsetsWithDup_90 {
    /**
     * Backtracking.
     *
     * @param nums input int array
     * @return list that contains all subsets
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
     * @param res  output list
     * @param temp temp list
     * @param nums int array
     * @param k    each recursion start position
     */
    private void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, int k) {
        res.add(new ArrayList<>(temp));
        for (int i = k; i < nums.length; i++) {

            if (i <= k || nums[i] != nums[i - 1]) {     // avoid duplicate subsets
                temp.add(nums[i]);
                backtracking(res, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
