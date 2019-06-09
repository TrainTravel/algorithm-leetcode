package Solution.DynamicProgramming;

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
     * Dynamic programming with a 2D array.
     * State transition:
     * dp[i][j] = dp[i-1][j-1], if word1.charAt(i-1) == word2.charAt(j-1)
     * dp[i+1][j+1] = min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])+1, otherwise
     *
     * @param word1 string 1
     * @param word2 target converted string
     * @return min edit distance
     */
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[i - 1][0] + 1;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        MinDistance_72 test = new MinDistance_72();
        System.out.println(test.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}
