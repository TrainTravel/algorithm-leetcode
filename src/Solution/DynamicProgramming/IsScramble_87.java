package Solution.DynamicProgramming;

/**
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * Note that s1 and s2 has same length.
 *
 * @author BorisMirage
 * Time: 2019/02/12 22:56
 * Created with IntelliJ IDEA
 */

public class IsScramble_87 {
    /**
     * Dynamic programming with 3D table.
     * i  i+q  i+k-1
     * j  j+q  j+k-1
     * j  j+k-q  j+k-1
     *
     * @param s1 first string
     * @param s2 second string
     * @return if s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {

//        if (s1.length()!=s2.length())return false;

        int l = s1.length();

        boolean[][][] temp = new boolean[l][l][l + 1];

        /* Check each single char in string */
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                temp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        /* Fixed split string position */
        for (int k = 2; k <= l; k++) {

            /* Find start position in s1 */
            for (int i = 0; i <= l - k; i++) {

                /* Find start position in s2 */
                for (int j = 0; j <= l - k; j++) {

                    for (int p = 1; p < k; p++) {
                        if (((temp[i][j][p] && temp[i + p][j + p][k - p])) || ((temp[i][j + k - p][p] && temp[i + p][j][k - p]))) {
                            temp[i][j][k] = true;
                        }
                    }
                }
            }
        }

        return temp[0][0][l];
    }
}
