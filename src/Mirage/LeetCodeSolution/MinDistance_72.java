package Mirage.LeetCodeSolution;


/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * 3 operations permitted on a word:
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 *
 * @author BorisMirage
 * Time: 2018/10/03 11:08
 * Created with IntelliJ IDEA
 */

public class MinDistance_72 {
    /**
     * Dynamic programming with filling a 2D array.
     *
     * @param s string 1
     * @param t target converted string
     * @return min edit distance
     */
    public int minDistance(String s, String t) {
        if (s.equals(t)) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        /* First row and column */
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;

        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        /* The rest of array */
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }
            }
        }
        return dp[s.length()][t.length()];
    }


    public static void main(String[] args) {
        MinDistance_72 test = new MinDistance_72();
        System.out.println(test.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}
