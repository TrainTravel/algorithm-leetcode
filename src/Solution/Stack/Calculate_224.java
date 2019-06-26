package Solution.Stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain parentheses (, ), plus + or minus -, non-negative integers and empty spaces " ".
 *
 * @author BorisMirage
 * Time: 2019/06/26 11:13
 * Created with IntelliJ IDEA
 */

public class Calculate_224 {
    /**
     * Use a stack to store calculate result of each operator and Operand.
     * Pop the sum of previous calculation with each operand.
     * If found a bracket, push a 0 to stack as an initially sum, and keep calculation.
     * After the bracket is end, pop the previous sum in bracket and before bracket to calculate the result.
     *
     * @param s given expression string
     * @return calculation result of s
     */
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);                          // always keep most recent sum at top

        for (int i = 0, sign = 1; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {      // calculate current numbers
                    num = num * 10 + (s.charAt(++i) - '0');     // ++i is equivalent to i = i + 1
                }
                stack.push(stack.pop() + sign * num);       // calculate previous sum and current integer
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {        // calculate the sum in brackets, and push the
                stack.push(sign);
                stack.push(0);      // initial sum in brackets are 0
                sign = 1;       // initial operator in brackets is positive
            } else if (s.charAt(i) == ')') {    // update last sum = current sum * sign
                stack.push(stack.pop() * stack.pop() + stack.pop());
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Calculate_224 test = new Calculate_224();
        System.out.println(test.calculate("(11+(42 + 15 + 2)-3)+(6+8)"));       // 81
        System.out.println(test.calculate("2147483647"));

    }
}
