package Solution.TwoPointers;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * @author BorisMirage
 * Time: 2019/06/19 16:14
 * Created with IntelliJ IDEA
 */

public class LengthOfLongestSubstringKDistinct_340 {
    /**
     * Sliding window (two pointers).
     * Use two pointers to point at the window start and window end.
     * If distinct char is more than K, then narrow the window size until all invalid char is excluded.
     *
     * @param s given string
     * @param k at most k distinct characters in result
     * @return length of the longest substring t that contains at most 2 distinct characters
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        /* Corner case */
        if (s.length() < k) {
            return s.length();
        }

        HashMap<Character, Integer> m = new HashMap<>();
        int start = 0, count = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
            count = (m.get(c) == 1) ? count + 1 : count;        // one more distinct char

            while (count > k) {     // narrow window size to exclude all invalid char
                char temp = s.charAt(start);
                m.put(temp, m.get(temp) - 1);
                count = (m.get(temp) == 0) ? count - 1 : count;     // remove a distinct char in window
                start++;        // narrow window size
            }
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
