package Mirage.LeetCodeSolution;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * Input: s1 = "ab", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 * @author BorisMirage
 * Time: 2019/01/20 22:24
 * Created with IntelliJ IDEA
 */

public class IsInterleave_97 {
    /**
     * DP with n^2 table.
     * Transform formula:
     * (i ,j) = ((i - 1, j) && s3(i + j - 1) == s1(i - 1)) || ((i, j - 1) && s3(i + j - 1) == s2(j - 1))
     *
     * @param s1 first string
     * @param s2 second string
     * @param s3 test string
     * @return whether s3 is formed by the interleaving of s1 and s2.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length() + 1;
        int l2 = s2.length() + 1;
        int l3 = s3.length() + 1;

        /* Special case */
        if (l1 + l2 != l3) {
            return false;
        }
        if (l1 + l2 + l3 == 3) {
            return true;
        }

        boolean[][] table = new boolean[l1 + 1][l2 + 1];

        /* First row and column */
        for (int i = 1; i < l1; i++) {
            table[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && (table[i - 1][0] || i == 1);
        }
        for (int i = 1; i < l2; i++) {
            table[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) && (table[0][i - 1] || i == 1);
        }

        /* Fill table */
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                table[i][j] = (table[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1))) || (table[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1)));
            }
        }
        return table[l1][l2];
    }

    public static void main(String[] args) {
        IsInterleave_97 test = new IsInterleave_97();
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(test.isInterleave("", "", ""));

    }
}
