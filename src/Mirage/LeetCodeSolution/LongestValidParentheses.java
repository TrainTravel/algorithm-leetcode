package Mirage.LeetCodeSolution;

import java.util.Stack;

/**
 * @author BorisMirage
 * Time: 2018/06/21 13:19
 * Created with IntelliJ IDEA
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

    /**
     * Another solution of this problem.
     * This class uses stack to store left parentheses' position.
     * If encounter right parenthesis, pop stack's top index and compare i - index to max length.
     * If stack is empty and encounter right parenthesis, push current index into stack as next valid length's start.
     * <p>
     * Time complexity: O(n). Single traversal of string to fill dp array is done.
     * Space complexity: O(n). stack at most store string's length
     *
     * @param s input parentheses string
     * @return longest valid parentheses length
     */
    public int longestValidParenthesesStack(String s) {
        if (s.length() < 2) {
            return 0;
        }

        Stack<Integer> leftStack = new Stack<>();

        /* -1 can be regarded as dummy head position */
        leftStack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else {
                leftStack.pop();
                if (leftStack.size() == 0) {

                    /* Dummy head for next valid parentheses length counting */
                    leftStack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - leftStack.peek());
                }
            }
        }
        return maxLength;
    }
}
