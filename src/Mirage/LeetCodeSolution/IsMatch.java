package Mirage.LeetCodeSolution;

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

public class IsMatch {
    /**
     * Dynamic programming.
     *
     * @param s string
     * @param p pattern string
     * @return if pattern matched
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

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                char str = s.charAt(row - 1);
                char pattern = p.charAt(col - 1);
                if (str == pattern || pattern == '?') {
                    dp[row][col] = dp[row - 1][col - 1];
                } else if (pattern == '*') {
                    dp[row][col] = dp[row][col - 1] || dp[row - 1][col];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        IsMatch isMatchTest = new IsMatch();
        System.out.println(isMatchTest.isMatch("aab", "c*a*b"));
        System.out.println(isMatchTest.isMatch("adceb", "*a*b"));
        System.out.println(isMatchTest.isMatch("acdcb", "a*c?b"));

    }
}
