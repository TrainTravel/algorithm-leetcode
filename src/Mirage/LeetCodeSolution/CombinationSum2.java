package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/23/18
 * Time: 20:02
 */

public class CombinationSum2 {
    /**
     * Given a collection of candidate numbers (candidates) and a target number (target).
     * Find all unique combinations in candidates where the candidate numbers sums to target.
     * Each number in candidates may only be used ONCE in the combination.
     * <p>
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * <p>
     * Use backtracking to find all combinations via traversing all elements in candidate array.
     *
     * @param candidates input candidate numbers
     * @param target     target numbers
     * @return result int list
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();

        /* Special Case */
        if (candidates.length == 0 || (candidates.length == 1 && target % candidates[0] != 0)) {
            return res;
        }

        /* Sort array to avoid duplication and use backtracking to find all combinations */
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    /**
     * Backtracking to find all combination that the sum is target.
     *
     * @param result     result output array list
     * @param temp       temp array list, if combination is found it will be added to result
     * @param candidates input candidates
     * @param remain     current input int, compare to target to check whether current combination correct
     * @param start      traverse start position in array
     */
    private void backtracking(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {

        /* Current sum is not larger than target */
        if (remain >= 0) {

            /* If current sum is 0, add temp list into result as current combination is current answer */
            if (remain == 0) {
                result.add(new ArrayList<>(temp));
            } else {

                /* Same recursion as CombinationSum except one more step to avoid duplicate */
                for (int i = start; i < candidates.length; i++) {

                    /* Remove duplicate elements in output */
                    if (i > start && candidates[i] == candidates[i - 1]) {
                        continue;
                    }

                    temp.add(candidates[i]);
                    backtracking(result, temp, candidates, remain - candidates[i], i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
