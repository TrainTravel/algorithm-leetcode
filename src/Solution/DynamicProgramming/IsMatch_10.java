package Solution.DynamicProgramming;

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
     * Each time, find current matched string and pattern. Check if string matches pattern before current matched part.
     * State transition:
     * If (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') ->  dp[i + 1][j + 1] = dp[i][j]
     * If (p.charAt(j) == '*'):
     * 1. p(j - 2) could only be matched for 0 time.
     * 2. Match p(j - 2) for 1 time.
     * 3. Match p(j - 1) for n times.
     * 4. Match p in format as ".*" 0 ~ n times.
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

        int l1 = s.length();
        int l2 = p.length();

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l2; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];        // for the case of pattern starts with .*
            }
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {

                /*
                 * If current char matches, or pattern is '.', then dp[i][j] = dp[i - 1][j - 1].
                 * Both pattern char and string char is matched, check string and pattern before matched. */
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                /*
                 * If p.charAt(j - 1) == '*', then matched pattern will be:
                 * 1. p(j - 2) could only be matched for 0 time.
                 * 2. Match p(j - 2) for 1 time.
                 * 3. Match p(j - 1) for n times.
                 * 4. Match p in format as ".*" 0 ~ n times. */
                if (p.charAt(j - 1) == '*') {

                    /*
                     * If s(i - 1) != p(j - 2) && p(j - 2) != '.', then no match found in p.
                     * p(j - 2) could only be matched for 0 time.
                     * Check if string matches pattern before '*' and its previous char. */
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {

                        /*
                         * Otherwise, there are three conditions:
                         * 1. Match p(j - 2) for 1 time: dp[i][j - 1]
                         * 2. Match p(j - 1) for n times: dp[i - 1][j] (this is actually only matched in s, not in p)
                         * 3. Match p in format as ".*" 0 ~ n times: dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j] */
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                    }
                }
            }
        }

        return dp[l1][l2];
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
