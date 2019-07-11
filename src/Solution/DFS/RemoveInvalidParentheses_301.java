package Solution.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 *
 * @author BorisMirage
 * Time: 2019/06/04 11:16
 * Created with IntelliJ IDEA
 */

public class RemoveInvalidParentheses_301 {
    /**
     * Iterate all chars in given string.
     * If find any invalid pair in string, backtrack to find all possible valid parentheses.
     * Finally, reverse string and do it again.
     *
     * @param s given parentheses pairs
     * @return all possible results.
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        checkInvalid(output, s, 0, 0, '(', ')');
        return output;
    }

    /**
     * If found invalid parenthesis, then use backtracking to find all possible substrings.
     *
     * @param output output list
     * @param s      parentheses string
     * @param a      index of parentheses string
     * @param b      index of invalid parenthesis right part
     * @param open   left part of parenthesis
     * @param close  right part of parenthesis
     *               when traverse from end to beginning, open and close will be swapped
     */
    private void checkInvalid(List<String> output, String s, int a, int b, char open, char close) {

        int left = 0, right = 0;

        for (int i = a; i < s.length(); i++) {

            if (s.charAt(i) == open) {
                left++;
            } else if (s.charAt(i) == close) {
                right++;
            }

            if (right > left) {     // if right is more than left, then current parenthesis is invalid pair

                for (int j = b; j <= i; j++) {      // backtracking to find all possibility

                    /* Try every possible substring without one invalid right parenthesis */
                    if (s.charAt(j) == close && (j == b || s.charAt(j - 1) != close)) {     // avoid duplication
                        checkInvalid(output, s.substring(0, j) + s.substring(j + 1), i, j, open, close);
                    }
                }
                return;
            }
        }

        /* Check reversed string in each iteration to find if left parenthesis is more than right parenthesis */
        String reversed = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            checkInvalid(output, reversed, 0, 0, ')', '(');
        } else {
            output.add(reversed);       // if s is valid pairs both directions, then add it to final output
        }
    }
}
