package Solution.DynamicProgramming;


/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * Example:
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * @author BorisMirage
 * Time: 2019/03/24 10:48
 * Created with IntelliJ IDEA
 */

public class MinCut_132 {
    /**
     * Dynamic programming with two 1D boolean array.
     * Assume i, j are the index in string, cut[i] is the min cut time for s(0, i).
     * 1. Assume s from 0 to i is not palindrome, set cut[i] = i initially.
     * 2. If s.char(j) == s.char(i) (j<=i) && s(j+1, i-1) is palindrome, then s(j, i) is palindrome.
     * 3. If s(j, i) is palindrome and s(0, j-1) is palindrome, then cut[i] = min(cut[i], cut[j - 1] + 1)
     *
     * @param s given string
     * @return min cuts for a palindrome partitioning of s
     */
    public int minCut(String s) {

        if (s.length() == 0) {
            return -1;
        }

        int[] minCut = new int[s.length()];

        /* dp1: is palindrome string from index 0 to i - 1. dp2: is palindrome string from index 0 to i */
        boolean[] dp1 = new boolean[s.length() + 1], dp2 = new boolean[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            minCut[i] = i;      // assume s from 0 to i is not palindrome
            for (int j = 0; j <= i; j++) {      // from j to i, i is fixed

                /* j + 1 > i - 1: single char is always palindrome */
                if (s.charAt(i) == s.charAt(j) && ((j + 1 > i - 1) || dp1[j + 1])) {
                    dp2[j] = true;
                    minCut[i] = j == 0 ? 0 : Math.min(minCut[i], minCut[j - 1] + 1);
                }
            }
            dp1 = dp2;
            dp2 = new boolean[s.length() + 1];
        }

        return minCut[s.length() - 1];
    }

    public static void main(String[] args) {
        MinCut_132 t = new MinCut_132();
        System.out.println(t.minCut("abcba"));
    }
}
