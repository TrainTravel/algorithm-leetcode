package Solution.DynamicProgramming;

import java.util.Arrays;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * @author BorisMirage
 * Time: 2019/08/21 18:20
 * Created with IntelliJ IDEA
 */

public class NumDistinct_115 {
    /**
     * Dynamic programming.
     * State transition:
     * dp[i][j] = dp[i][j - 1], if s.charAt(j - 1) == t.charAt(i - 1), then dp[i][j] += dp[i - 1][j - 1]
     * dp[i][j]: S(0, j) contains distinct subsequences of T(0, i).
     * If T[i] != S[j], then dp[i,j] = dp[i,j-1], since current char will not be taken.
     * If T[i] == S[j], then current char can be taken to make the last char of T.
     * Under this condition, dp[i][j] = dp[i-1][j-1], which is # of previous condition.
     * Current char is last char that made up of subsequence, therefore, no extra value needed under this condition.
     * But it is also possible that current char is not taken, which is same as first situation.
     *
     * @param s string not longer than t
     * @param t second string
     * @return number of distinct subsequences of S which equals T
     */
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] dp = new int[m + 1][n + 1];

        Arrays.fill(dp[0], 1);      // empty string is a subsequence

        for (int i = 1; i < dp.length; i++) {     // row: char in t
            for (int j = 1; j < dp[0].length; j++) {      // column: char in s

                /*
                 * Two conditions:
                 * 1. If chars in S and T is not matched, then dp[i][j] = dp[i][j-1]. Char in S will not influence [j-1]
                 * 2. If two chars is matched, then based on condition 1, dp[i][j] += dp[i - 1][j - 1].
                 * dp[i - 1][j - 1]: S(0, j - 1) contains distinct subsequences of T(0, i - 1) */
                dp[i][j] = dp[i][j - 1];

                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
