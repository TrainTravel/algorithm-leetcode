package Solution.DynamicProgramming;

/**
 * Given an array of scores that are non-negative integers.
 * Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
 * Each time a player picks a number, that number will not be available for the next player.
 * This continues until all the scores have been chosen. The player with the maximum score wins.
 * Given an array of scores, predict whether player 1 is the winner.
 * You can assume each player plays to maximize his score.
 *
 * @author BorisMirage
 * Time: 2019/09/16 14:48
 * Created with IntelliJ IDEA
 */

public class PredictTheWinner_486 {
    /**
     * Min-max problem can be solved by dynamic programming.
     * The key of this problem is to correctly define dp[i][j].
     * State transition:
     * dp[i][j]: how much more scores that the first-in-action player will get from i to j than the second player.
     * dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1], where 0 <= i < j < n and i + j < n.
     * Base case:
     * dp[i][i] = i
     * At each dp[i][j], the max dp[i][j] is actually to find the max result that last player can get.
     * The reason is that under the rule of game, each player will try the strategy that max its score.
     * Therefore, to find if player 1 can win, check the max points player 2 can reach and decide if player 1 can win.
     *
     * @param nums given int array
     * @return predict whether player 1 is the winner
     */
    public boolean predictTheWinner(int[] nums) {

        /* Corner case */
        if (nums.length % 2 == 0 || nums.length < 2) {
            return true;
        }

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int length = 1; length <= n; length++) {           // iterate each length
            for (int i = 0; i < n - length; i++) {              // iterate each start index with fixed length
                int j = i + length;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}
