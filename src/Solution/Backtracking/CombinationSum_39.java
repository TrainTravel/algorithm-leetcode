package Solution.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target).
 * Find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author BorisMirage
 * Time: 2018/06/22 21:56
 * Created with IntelliJ IDEA
 */

public class CombinationSum_39 {
    /**
     * Use backtracking to find all combinations via traversing all elements in candidate array.
     *
     * @param candidates input candidate numbers
     * @param target     target numbers
     * @return result int list
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();

        /* Sort array to avoid duplication and use backtracking to find all combinations */
        Arrays.sort(candidates);
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

                /* If current sum is smaller than target, traverse all elements in array include candidates[i] itself */
                for (int i = start; i < candidates.length; i++) {

                    /* Add current candidate to temp list */
                    temp.add(candidates[i]);
                    backtracking(result, temp, candidates, remain - candidates[i], i);

                    /* If current sum is larger than target, remove last element */
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        /* Combination Sum */
        int[] candidate = {2, 3, 6, 7};
        CombinationSum_39 combinationSumTest = new CombinationSum_39();
        System.out.println(combinationSumTest.combinationSum(candidate, 7));
        candidate = new int[]{2, 3, 5};
        System.out.println(combinationSumTest.combinationSum(candidate, 8));
    }
}
