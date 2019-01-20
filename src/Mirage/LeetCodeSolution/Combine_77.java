package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * @author BorisMirage
 * Time: 2018/08/09 12:51
 * Created with IntelliJ IDEA
 */

public class Combine_77 {
    /**
     * This problem can be solved in backtracking method.
     * However, there is another approach that can solve this problem in a faster way.
     * This is based on C(n, k) = C(n - 1, k - 1) + C(n - 1, k).
     * The problem itself is C(n, k), hence, break this problem into C(n - 1, k - 1) + C(n - 1, k), which is recursion.
     *
     * @param n set from 1 to n
     * @param k each combination length
     * @return List contains all combinations
     */
    public List<List<Integer>> combine(int n, int k) {

        /* C(n, k) = C(n - 1, k - 1) + C(n - 1, k) */
        List<List<Integer>> res = new LinkedList<>();
        if (n < k || k == 0) {
            return res;
        }

        /* C(n - 1, k - 1) */
        res = combine(n - 1, k - 1);

        /* Add int to list in each sub problem */
        if (res.isEmpty()) {
            res.add(new LinkedList<>());
        }
        for (List<Integer> list : res) {
            list.add(n);
        }

        /* C(n - 1, k) */
        res.addAll(combine(n - 1, k));
        return res;
    }
}