package Solution.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a array of distinct integers.
 * Return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author BorisMirage
 * Time: 2018/08/09 13:44
 * Created with IntelliJ IDEA
 */

public class Subsets_78 {
    /**
     * Backtracking.
     *
     * @param nums input int array
     * @return list that contains all subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();

        if (nums.length == 0) {
            return output;
        }

        Arrays.sort(nums);      // avoid duplication
        backtracking(output, new LinkedList<>(), nums, 0);
        return output;
    }

    /**
     * Basic backtracking.
     * Each iteration starts at next int from previous iteration.
     *
     * @param output output list
     * @param temp   temp list
     * @param nums   int array
     * @param k      each recursion start position
     */
    private void backtracking(List<List<Integer>> output, List<Integer> temp, int[] nums, int k) {
        output.add(new ArrayList<>(temp));     // every subset should be added to final result
        for (int i = k; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(output, temp, nums, i + 1);
            temp.remove(temp.size() - 1);       // avoid duplication

        }
    }

}
