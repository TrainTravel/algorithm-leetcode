package Solution.DynamicProgramming;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * Note:
 * 1. s could be empty and contains only lowercase letters a-z.
 * 2. p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * @author BorisMirage
 * Time: 2018/10/11 10:20
 * Created with IntelliJ IDEA
 */

public class IsMatch_44 {
    /**
     * Dynamic programming with 2D table.
     * Conditions:
     * if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') ->  dp[i + 1][j + 1] = dp[i][j]
     * if (p.charAt(j) == '*'): since '*' can match empty string, then directly fill dp[i + 1][j] || dp[i][j + 1]
     * If either condition is satisfied, return false.
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

        int l1 = s.length(), l2 = p.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;        // empty string matches empty string

        for (int i = 1; i <= l2; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];        // '*' can match empty string
            }
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {

                    /*
                     * dp[i + 1][j]: matches any sequence 1 ~ n times.
                     * dp[i][j + 1]: matches empty sequence. */
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        IsMatch_44 isMatchTest = new IsMatch_44();
        System.out.println(isMatchTest.isMatch("aab", "c*a*b"));
        System.out.println(isMatchTest.isMatch("adceb", "*a*b"));
        System.out.println(isMatchTest.isMatch("acdcb", "a*c?b"));
        System.out.println(isMatchTest.isMatch("aa", "*a"));
    }
}
