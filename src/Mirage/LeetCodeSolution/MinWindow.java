package Mirage.LeetCodeSolution;

/**
 * Given a string S and a string T.
 * Find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, it can be guaranteed that there will always be only one unique minimum window in S.
 *
 * @author BorisMirage
 * Time: 2018/10/01 20:59
 * Created with IntelliJ IDEA
 */

public class MinWindow {
    /**
     * Use two pointer, one find all char in s first, the other one try to narrow the window in s.
     * Use a int array as hash map.
     *
     * @param s input string
     * @param t all chars needs to be found in s
     * @return min string that contains all chars in t
     */
    public String minWindow(String s, String t) {
        String res = "";

        if (s.length() < 1 || t.length() < 1) {
            return res;
        }

        int rest = t.length(), start = -1, minWindow = Integer.MAX_VALUE;
        int[] duplicateChar = new int[128];

        /* Count each char's appearance */
        for (char c : t.toCharArray()) {
            duplicateChar[c]++;
        }

        int fast = 0, slow = 0;

        while (fast < s.length()) {


            char cur = s.charAt(fast++);

            /* Found a char in s that contains char in t, minus 1 in char count */
            if (duplicateChar[cur]-- > 0) {
                rest--;     // chars needs to be found in t minus 1
            }

            /* Try to narrow the window in s */
            while (rest == 0) {

                /* If any char in t was found, stop narrow process */
                if (duplicateChar[s.charAt(slow++)]++ == 0) {
                    rest++;
                }

                /* Find min window */
                if (fast - slow + 1 < minWindow) {
                    minWindow = fast - slow + 1;
                    start = slow - 1;
                }
            }
        }
        return start == -1 ? "" : s.substring(start, start + minWindow);
    }
}
