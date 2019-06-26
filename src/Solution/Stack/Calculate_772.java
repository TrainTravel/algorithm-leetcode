package Solution.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain parentheses, the plus + or minus sign -, non-negative integers and empty spaces .
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces .
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * All intermediate results will be in the range of [-2147483648, 2147483647].
 *
 * @author BorisMirage
 * Time: 2019/06/26 15:01
 * Created with IntelliJ IDEA
 */

public class Calculate_772 {
    /**
     * Use a deque to store operands and operators.
     *
     * @param s expression string
     * @return calculation result of s
     */
    public int calculate(String s) {
        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;

        Deque<Integer> stack = new ArrayDeque<>();      // stack to simulate recursion

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '(') {

                /* Preserve current calculation status.
                 * Then reset them for next calculation.*/
                stack.offerFirst(l1);
                stack.offerFirst(o1);
                stack.offerFirst(l2);
                stack.offerFirst(o2);
                l1 = 0;
                o1 = 1;
                l2 = 1;
                o2 = 1;

            } else if (c == ')') {

                /*
                 * First preserve the result of current calculation.
                 * Then restore previous calculation status. */
                int num = l1 + o1 * l2;
                if (stack.size() > 0) {
                    o2 = stack.poll();
                }
                if (stack.size() > 0) {
                    l2 = stack.poll();
                }
                if (stack.size() > 0) {
                    o1 = stack.poll();
                }
                if (stack.size() > 0) {
                    l1 = stack.poll();
                }

                l2 = (o2 == 1 ? l2 * num : l2 / num);       // previous calculation status is now in effect

            } else if (c == '*' || c == '/') {
                o2 = (c == '*' ? 1 : -1);

            } else if (c == '+' || c == '-') {
                if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                    o1 = -1;
                    continue;
                }
                l1 = l1 + o1 * l2;
                o1 = (c == '+' ? 1 : -1);

                l2 = 1;
                o2 = 1;
            }
        }

        return (l1 + o1 * l2);
    }
}
