package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * @author BorisMirage
 * Time: 2018/08/09 12:51
 * Created with IntelliJ IDEA
 */

public class Combine {
    /**
     * Backtracking.
     *
     * @param n set from 1 to n
     * @param k each combination length
     * @return List contains all combinations
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cache = new LinkedList<>();
        backtracking(res, cache, n, k, 1);
        return res;
    }

    /**
     * Backtracking.
     *
     * @param res   output List
     * @param cache temp List
     * @param n     set from 1 to n
     * @param k     each combination length
     * @param cur   current added int
     */
    private void backtracking(List<List<Integer>> res, List<Integer> cache, int n, int k, int cur) {
        if (cache.size() == k) {
            res.add(new ArrayList<>(cache));
        } else {
            for (int i = cur; i < n + 1; i++) {
                cache.add(i);

                /* cur set to i + 1 to avoid duplication */
                backtracking(res, cache, n, k, i + 1);
                cache.remove(cache.size() - 1);
            }
        }
    }
}