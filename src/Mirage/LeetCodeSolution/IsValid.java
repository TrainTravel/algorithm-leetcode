package Mirage.LeetCodeSolution;

import java.util.Stack;

/**
 * @author BorisMirage
 * Time: 2018/06/12 17:52
 * Created with IntelliJ IDEA
 */

public class IsValid {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * <p>
     * Use stack to solve this problem. While char is left part of parentheses, push its right part to stack.
     * When char is right part, pop stack and compare.
     *
     * @param s input parentheses
     * @return boolean value that whether this input string is valid
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

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

    public static void main(String[] args) {

        /* Parentheses Test */
        IsValid isValidTest = new IsValid();
        System.out.println(isValidTest.isValid("()[]{}"));
    }
}
