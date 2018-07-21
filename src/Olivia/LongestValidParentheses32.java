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
                } else {
                    s1.push(i);
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

    //Dynamic Programming
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }
                else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = dp[i-1] + ((i-dp[i-1]-1)>=2?dp[i-dp[i-1]-2]:0)+2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

}
