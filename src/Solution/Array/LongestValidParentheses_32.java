package Solution.Array;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')'.
 * Find the length of the longest valid (well-formed) parentheses substring.
 *
 * @author BorisMirage
 * Time: 2018/06/21 13:19
 * Created with IntelliJ IDEA
 */

public class LongestValidParentheses_32 {
    /**
     * Traverse s for two times, set two counter "left" and "right" to count "(", ")" respectively.
     * First from left to right, if left equals to right and none of them are 0, then one valid length is found.
     * Compare current length to max length. If larger then switch it. Then reset both counters.
     * When first traverse completed, traverse string from right to left with same process.
     * Final max length is the result.
     * Analysis:
     * Time complexity: O(n). Single traversal of string to fill dp array is done.
     * Space complexity: O(1). Three local variables are used.
     *
     * @param s input string
     * @return length of the longest valid (well-formed) parentheses substring
     */
    public int longestValidParentheses(String s) {

        /* Corner case */
        if (s.length() < 2) {
            return 0;
        }

        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {      // traverse from left to right
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left + right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        for (int i = s.length() - 1; i > -1; i--) {     // traverse from right to left
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left + right);
            } else if (right < left) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }

    /**
     * Another solution of this problem that uses stack to store left parentheses' position.
     * If encounter right parenthesis, pop stack's top index and compare i - index to max length.
     * If stack is empty and encounter right parenthesis, push current index into stack as next valid length's start.
     * Analysis:
     * Time complexity: O(n). Single traversal of string to fill dp array is done.
     * Space complexity: O(n). Stack at most store string's length
     *
     * @param s input parentheses string
     * @return longest valid parentheses length
     */
    public int longestValidParenthesesStack(String s) {

        /* Corner case */
        if (s.length() < 2) {
            return 0;
        }

        /* Stack that store left parentheses */
        Stack<Integer> leftStack = new Stack<>();

        /* -1 can be regarded as “extended” start position */
        leftStack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else {
                leftStack.pop();
                if (leftStack.size() == 0) {

                    /* Start position for next valid parentheses length counting */
                    leftStack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - leftStack.peek());
                }
            }
        }
        return maxLength;
    }

    /**
     * Using dynamic programming to solve this problem.
     * This approach is faster than previous one.
     * <p>
     * Time complexity: O(n). Single traversal of string to fill dp array is done.
     * Space complexity: O(n). dp array of size n is used.
     *
     * @param s input string
     * @return longest valid parentheses length
     */
    public int longestValidParenthesesDP(String s) {

        /* Record temp max length result */
        int[] arr = new int[s.length()];
        int maxParentheses = 0;

        for (int i = 1; i < s.length(); i++) {

            /* If current char is ')', then find previous state */
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i > 1) {
                        arr[i] = arr[i - 2] + 2;
                    } else {
                        arr[i] = 2;
                    }
                } else if (i > arr[i - 1] && s.charAt(i - arr[i - 1] - 1) == '(') {

                    /* i - arr[i - 1] - 1: find first '(' */
                    if (i - arr[i - 1] > 1) {
                        arr[i] = arr[i - 1] + arr[i - arr[i - 1] - 2] + 2;
                    } else {
                        arr[i] = arr[i - 1] + 2;
                    }
                }
                maxParentheses = Math.max(maxParentheses, arr[i]);
            }
        }
        return maxParentheses;
    }

}
