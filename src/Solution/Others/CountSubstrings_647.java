package Solution.Others;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * Substrings with different start or end indexes are counted as different substrings even consist of same characters.
 *
 * @author BorisMirage
 * Time: 2020/03/05 10:32
 * Created with IntelliJ IDEA
 */

public class CountSubstrings_647 {
    /**
     * Extend from center to find palindromic substrings at each character.
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param s given string
     * @return count number of palindromic substrings in this string
     */
    public int countSubstrings(String s) {

        /* Corner case */
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extend(s, i, i);                 // odd length palindromic substring center
            count += extend(s, i, i + 1);       // even length palindromic substring center
        }

        return count;
    }

    /**
     * Extend from current index to find palindromic substrings.
     * If left == right, then count number of odd length palindromic substrings.
     * If left == right - 1, then count number of even length palindromic substrings
     *
     * @param s     given string
     * @param left  left start position
     * @param right right start position
     * @return number of palindromic substrings
     */
    private int extend(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }

        return count;
    }
}