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
     * Dynamic programming.
     *
     * @param s string
     * @param p pattern string
     * @return if string is matched to pattern
     */
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else
                break;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        IsMatch_44 isMatchTest = new IsMatch_44();
        System.out.println(isMatchTest.isMatch("aab", "c*a*b"));
        System.out.println(isMatchTest.isMatch("adceb", "*a*b"));
        System.out.println(isMatchTest.isMatch("acdcb", "a*c?b"));

    }
}
