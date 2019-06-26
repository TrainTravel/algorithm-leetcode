package Solution.Stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * @author BorisMirage
 * Time: 2019/06/26 14:31
 * Created with IntelliJ IDEA
 */

public class Calculate_227 {
    /**
     * Use a stack to store each number in string, and assign sign based on previous operator: '+', '-'.
     * If found a '*' or '/', pop the last element and do the corresponding calculation, then push the result.
     * Finally, calculate sum of all values in stack.
     *
     * @param s expression string
     * @return calculation result of s
     */
    public int calculate(String s) {

        /* Corner case */
        if (s.length() < 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';     // find operand
            }

            if (s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i)) || i == s.length() - 1) {     // find operator after operand
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);      // * have higher priority
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        num = 0;
        for (Integer i : stack) {
            num += i;
        }

        return num;
    }

    public static void main(String[] args) {
        Calculate_227 test = new Calculate_227();
        System.out.println(test.calculate("1*3+2+3+3*2"));
    }
}
