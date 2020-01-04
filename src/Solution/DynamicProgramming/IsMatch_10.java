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

        int ls = s.length();
        int lp = p.length();

        boolean[][] dp = new boolean[ls + 1][lp + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lp; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];        // for the case of pattern starts with .*
            }
        }

        for (int i = 1; i <= ls; i++) {
            for (int j = 1; j <= lp; j++) {

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
                         * 3. Match p in format as ".*" 0 ~ n times: dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2] */
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }

        return dp[ls][lp];
    }

    /**
     * Use DFS to find whether s is matched to p.
     * During the searching process, use a 2D int array to record previous result as pruning.
     * Branch of DFS:
     * If (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'), return dfs(i + 1, j + 1).
     * Else, s(i) can not match p(j), if p(j + 1) is '*', then '*' matches empty substring, move to dfs(i, j + 2).
     * Finally, if p(j) == '*', then current character could be matched from 2 to n times.
     * Under this condition, try dfs(i - 1, j + 1) and move i forward, find the end of repeating character.
     * If the next character of repeating char is matched to next char in p after '*', continue until reaches the end.
     * Otherwise, s is not matched with p.
     *
     * @param s string
     * @param p pattern string
     * @return if string is matched to pattern
     */
    public boolean dfsImplementation(String s, String p) {

        /* Corner case */
        if (p == null || s == null) {
            return false;
        }

        /*
         * mem[i][j]: if s(0, i) can be matched with p.
         * If mem[i][j] can be matched with p(0, j), then move i and j forward until reaches the end of s and p.
         * If s finally matches with p, set mem[i][j] to 1 and return 1.
         * Otherwise, set mem[i][j] to -1 and return -1. */
        int[][] mem = new int[s.length() + 1][p.length() + 1];
        mem[s.length()][p.length()] = 1;

        /*
         * Set base case when DFS reaches the end of s. Two cases will be marked as matched:
         * 1. Pattern ends with '*'. '*' can match empty substring, hence, the second last character can be ignored.
         * 2. Last character. If last character is not matched, it will not be moving to next position in matrix. */
        for (int i = p.length(); i >= 0 && (i == p.length() || (i < p.length() && p.charAt(i + 1) == '*')); i -= 2) {
            mem[s.length()][i] = 1;
        }

        return dfs(s, p, 0, 0, mem) == 1;
    }

    /**
     * DFS searching with a 2D int table for pruning (can be replaced by hash map).
     * Compare one character each time.
     *
     * @param s   string
     * @param p   pattern string
     * @param i   current index of string
     * @param j   current index of pattern
     * @param mem 2D boolean array to store the previous result
     * @return if string is matched to pattern, return 1, otherwise return -1
     */
    private int dfs(String s, String p, int i, int j, int[][] mem) {

        if (mem[i][j] != 0) {      // memorization
            return mem[i][j];
        }

        if (j >= p.length()) {      // avoid out of bound
            return -1;
        }

        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {     // match single char
            mem[i][j] = dfs(s, p, i + 1, j + 1, mem);
            return mem[i][j];
        } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {      // match empty substring with '*'
            mem[i][j] = dfs(s, p, i, j + 2, mem);
            return mem[i][j];
        } else if (p.charAt(j) == '*') {        // match previous char in p 2 ~ n times
            int previous = i - 2;

            /*
             * To match a char for 1 ~ n times, only requires to find the next char of repeating character.
             * For instance, "abcddddef" can be matched to "abcd*ef".
             * First 'd' matches first 'd' in pattern, and the next and repeating 'd' matches '*'.
             * If s and p are matched, the next character in s should be same to the char next to '*' in p.
             * Therefore, find the next char in s after the repeating character.
             * If reaches the end of s, then the mem will handle it, since mem has been processed. */
            while (previous < s.length() && (previous == i - 2 || s.charAt(previous) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                previous++;
                if (dfs(s, p, previous, j + 1, mem) == 1) {
                    mem[i][j] = 1;
                    return mem[i][j];
                }
            }
        }

        mem[i][j] = -1;
        return -1;
    }

    public static void main(String[] args) {

        IsMatch_10 test = new IsMatch_10();
        String s = "ab";
        String p = ".*";
        System.out.println(test.dfsImplementation(s, p));     // T

        s = "mississippi";
        p = "mis*is*p*.";
        System.out.println(test.dfsImplementation(s, p));     // F

        s = "aasdfasdfasdfasdfas";
        p = "aasdf.*asdf.*asdf.*asdf.*s";
        System.out.println(test.dfsImplementation(s, p));     // T
    }
}
