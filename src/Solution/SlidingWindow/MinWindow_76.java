package Solution.SlidingWindow;

/**
 * Given a string S and a string T.
 * Find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Note:
 * 1. If there is no such window in S that covers all characters in T, return the empty string "".
 * 2. If there is such window, it is guaranteed that there will always be only one unique minimum window in S.
 *
 * @author BorisMirage
 * Time: 2019/06/18 11:25
 * Created with IntelliJ IDEA
 */

public class MinWindow_76 {
    /**
     * Use two pointers, one find all char in s first, the other one try to narrow the window in s.
     * Use a int array as hash map.
     *
     * @param s first string
     * @param t second string
     * @return minimum window in S which will contain all the characters in T
     */
    public String minWindow(String s, String t) {

        /* Corner case */
        if (s.length() < 1 || t.length() < 1) {
            return "";
        }

        int rest = t.length(), start = -1, window = Integer.MAX_VALUE;

        int[] countChar = new int[127];     // contains all printable chars from 32 - 126
        for (char c : t.toCharArray()) {
            countChar[c]++;     // count total chars in array
        }

        int fast = 0, slow = 0;      // two pointers

        while (fast < s.length()) {

            /* Each time, if current char is found in T, then reduce pending finding length in T.
             * If pending length is 0, then try to narrow the searching window.*/
            if (countChar[s.charAt(fast++)]-- > 0) {
                rest--;
            }

            /*
             * When no more char requires to be found in S, reduce the window to find min window size.
             * During the narrow process, there are two conditions: remove a char in T or not in T.
             * If one char in T is removed, the narrow process should stop.
             * Otherwise, find min window size during narrowing. */
            while (rest == 0) {

                if (countChar[s.charAt(slow++)]++ == 0){
                    rest++;     // avoid filter out char in T
                }

                if (fast - slow + 1 < window) {
                    window = fast - slow + 1;
                    start = slow - 1;
                }
            }
        }

        return (start == -1) ? "" : s.substring(start, start + window);
    }

    public static void main(String[] args) {
        MinWindow_76 test = new MinWindow_76();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
    }
}
