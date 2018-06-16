package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/12/18
 * Time: 17:52
 */

public class IsValid {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Use stack to solve this problem. While char is left part of parentheses, push its right part to stack.
     * When char is right part, pop stack and compare.
     *
     * @param s input parentheses
     * @return boolean value that whether this input string is valid
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        /* Every char in s */
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
