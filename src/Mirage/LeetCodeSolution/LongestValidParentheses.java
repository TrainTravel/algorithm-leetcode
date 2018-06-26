package Mirage.LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/21/18
 * Time: 13:19
 */

public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')'.
     * Find the length of the longest valid (well-formed) parentheses substring.
     * <p>
     * Traverse s for two times, set two counter "left" and "right" to count "(", ")" respectively.
     * First from left to right, if left equals to right and none of them are 0, then one valid length is found.
     * Compare current length to max length. If larger then switch it. Then reset both counters.
     * When first traverse completed, traverse string from right to left with same process.
     * Final max length is the result.
     *
     * @param s input string
     * @return length of the longest valid (well-formed) parentheses substring
     */
    public int longestValidParentheses(String s) {

        /* Special Case */
        if (s.length() < 2) {
            return 0;
        }

        int maxValid = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }

            /* If right is larger than left, reset counter and left for next traverse */
            if (left == right) {
                maxValid = Integer.max(maxValid, left + right);
            } else if (right >= left) {
                left = 0;
                right = 0;
            }
        }

        /* Next traverse */
        left = 0;
        right = 0;
        for (int j = s.length() - 1; j >= 0; j--) {

            if (s.charAt(j) == '(') {
                left += 1;
            } else {
                right += 1;
            }
            if (left == right) {
                maxValid = Integer.max(maxValid, left + right);
            } else if (right <= left) {
                left = 0;
                right = 0;
            }
        }
        return maxValid;
    }
}
