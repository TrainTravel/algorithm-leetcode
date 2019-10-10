package Solution.DynamicProgramming;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * @author BorisMirage
 * Time: 2019/03/24 10:48
 * Created with IntelliJ IDEA
 */

public class MinCut_132 {
    /**
     * Dynamic programming with two 1D boolean array.
     * Assume i, j are the index in string, cut[i] is the min cut time for s(0, i).
     * 1. If s(j, i) is palindrome, cut[i] is the minimum of cut[j - 1] + 1 (j <= i)
     * 2. If s(j, i) is palindrome, then [j + 1, i - 1] is palindrome, and c[j] == c[i].
     * Time complexity: O(n^3) -> O(n^2)
     * Space complexity: O(n^2)
     *
     * @param s given string
     * @return min cuts for a palindrome partitioning of s
     */
    public int minCut(String s) {

        /* Corner case */
        if (s.length() < 2) {
            return 0;
        }

        int[] min = new int[s.length()];        // min cut at each position of string
        boolean[][] dp = new boolean[s.length()][s.length()];       // if s(i, j) is palindrome

        for (int i = 0; i < s.length(); i++) {
            min[i] = i;       // initial value, assume string is not palindrome

            for (int j = 0; j <= i; j++) {      // iter sub string
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {        // j + 1 > i - 1: adjacent char
                    dp[j][i] = true;
                    min[i] = (j == 0) ? 0 : Math.min(min[i], min[j - 1] + 1);     // j == 0: first char always palindrome
                }
            }
        }

        return min[s.length() - 1];
    }

    public static void main(String[] args) {
        MinCut_132 t = new MinCut_132();
        System.out.println(t.minCut("abcba"));
        System.out.println(t.minCut("cabababcbc"));
    }
}
