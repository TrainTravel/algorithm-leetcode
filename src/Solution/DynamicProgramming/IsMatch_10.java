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

    /**
     * Use DFS searching to find if s is matched to p.
     * During the searching process, use a 2D int array to record previous result as pruning.
     *
     * @param s string
     * @param p pattern string
     * @return if string is matched to pattern
     */
    public boolean dfsImpl(String s, String p) {

        /* Corner case */
        if (p == null || s == null) {
            return false;
        }

        int[][] mem = new int[s.length() + 1][p.length() + 1];

        for (int i = p.length(); i >= 0 && (i == p.length() || (i < p.length() && p.charAt(i + 1) == '*')); i -= 2) {
            mem[s.length()][i] = 1;
        }

        return dfs(s, p, 0, 0, mem);
    }

    /**
     * DFS searching with a 2D int table to accomplish pruning (can be done by hash map).
     *
     * @param s   string
     * @param p   pattern string
     * @param i   current index of string
     * @param j   current index of pattern
     * @param mem 2D boolean array to store the previous result
     * @return if string is matched to pattern
     */
    private boolean dfs(String s, String p, int i, int j, int[][] mem) {

        if (mem[i][j] != 0) {      // reuse previous result
            return mem[i][j] == 1;
        }

        if (j >= p.length()) {      // avoid overflow
            return false;
        }

        if (p.charAt(j) == '*') {
            int n = i - 2;

            /*
             * n - 2: char in pattern before * and one char ahead. This is to handle the case where * matches 0 times.
             * 1. If '*' is the second char in pattern: n == i - 2
             * 2. If '*' matches 0 times in s
             * If char before '*' is '.', then it can match for any char for any times: p.charAt(j - 1) == '.' */
            while (n < s.length() && (n == i - 2 || s.charAt(n) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                if (dfs(s, p, ++n, j + 1, mem)) {
                    mem[i][j] = 1;
                    return true;
                }
            }
        } else if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            mem[i][j] = dfs(s, p, i + 1, j + 1, mem) ? 1 : -1;
            return mem[i][j] == 1;
        } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {      // match previous char more than 1 time
            mem[i][j] = dfs(s, p, i, j + 2, mem) ? 1 : -1;
            return mem[i][j] == 1;
        }

        return false;
    }

    public static void main(String[] args) {

        IsMatch_10 test = new IsMatch_10();
        String s = "ab";
        String p = ".*";
        System.out.println(test.dfsImpl(s, p));     // T

        s = "mississippi";
        p = "mis*is*p*.";
        System.out.println(test.dfsImpl(s, p));     // F

        s = "aasdfasdfasdfasdfas";
        p = "aasdf.*asdf.*asdf.*asdf.*s";
        System.out.println(test.dfsImpl(s, p));     // T
    }

}
