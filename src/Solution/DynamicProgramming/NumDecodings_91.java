package Solution.DynamicProgramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * @author BorisMirage
 * Time: 2019/02/23 13:20
 * Created with IntelliJ IDEA
 */

public class NumDecodings_91 {
    /**
     * Dynamic programming with 1D table.
     * Traverse s from back to front to avoid initial '0'.
     *
     * @param s given int string
     * @return total number of ways to decode it
     */
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] t = new int[s.length() + 1];

        t[s.length()] = 1;
        t[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;

        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {

                /* (i ,i + 1), two digits */
                t[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? t[i + 1] + t[i + 2] : t[i + 1];
            }
        }
        return t[0];

    }
}
