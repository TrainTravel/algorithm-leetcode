package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/13/18
 * Time: 10:21
 */

public class GenerateParenthesis {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * Use recursion to insert pair of parentheses in one pair of parentheses's left and right, respectively.
     *
     * @param n pairs of parentheses
     * @return linked list that contains all combinations of parentheses
     */

    public List<String> generateParenthesis(int n) {
        LinkedList<String> ans = new LinkedList<>();
        if (n == 0) {

            /* Pair 0 - add nothing */
            ans.add("");
        } else {
            for (int c = 0; c < n; c++)

                /* Recursion iterator */
                for (String left : generateParenthesis(c)) {
                    for (String right : generateParenthesis(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
        }
        return ans;
    }
}
