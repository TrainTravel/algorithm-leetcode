package Olivia;

import java.util.Stack;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        int max_length = 0;
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                s1.push(i);
            } else {
                if (!s1.isEmpty()) {
                    if (s.charAt(s1.peek()) == '(') {
                        s1.pop();
                    } else {
                        s1.push(i);
                    }
                }
            }
        }
        if (s1.isEmpty()) {
            max_length = s.length();
        } else {
            int endLoc = s.length();
            int startLoc = 0;
            while (!s1.isEmpty()) {
                startLoc = s1.peek();
                s1.pop();
                max_length = Math.max(max_length, endLoc - startLoc - 1);
                endLoc = startLoc;
            }
            max_length = Math.max(max_length, endLoc);
        }
        return max_length;

    }
}
