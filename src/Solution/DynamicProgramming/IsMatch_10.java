package Solution.DynamicProgramming;

import java.util.Arrays;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * @author BorisMirage
 * Time: 2018/10/11 21:25
 * Created with IntelliJ IDEA
 */

public class IsMatch_10 {
    /**
     * Dynamic programming with 2D table.
     * Conditions:
     * If (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') ->  dp[i + 1][j + 1] = dp[i][j]
     * If (p.charAt(j) == '*'):
     * 1. p.charAt(j - 1) != s.charAt(i): match previous char in 0 time
     * 2. p.charAt(j - 1) == s.charAt(i): match either previous char in string or pattern, or match previous char 0 time
     * If no condition satisfied, return false.
     *
     * @param s string
     * @param p pattern string
     * @return if string is matched to pattern
     */
    public boolean isMatch(String s, String p) {

        /* Corner case */
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {       // only p contains '.' or '*'
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];        // if previous string & pattern is matched, then it matches now
                }

                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];        // match char before '*' pattern
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];        // match either previous string or pattern, or 0 time
                    }
                }
            }
        }

        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        IsMatch_10 test = new IsMatch_10();
        String s = "ab";
        String p = ".*";
        System.out.println(test.isMatch(s, p));

//        test = new IsMatch_10();
//        s = "mississippi";
//        p = "mis*is*p*.";
//        System.out.println(test.isMatch(s, p));

        test = new IsMatch_10();
        s = "aasdfasdfasdfasdfas";
        p = "aasdf.*asdf.*asdf.*asdf.*s";
        System.out.println(test.isMatch(s, p));
    }

}
