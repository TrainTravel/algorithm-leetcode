package Solution.SlidingWindow;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author BorisMirage
 * Time: 2018/03/23 12:27
 * Created with IntelliJ IDEA
 */

public class LengthOfLongestSubstring_3 {
    /**
     * Sliding window problem.
     * Use a pointer to point at the start position, and a hash map to save each char's position.
     * If current char does not exist in map, then store this char and its next position.
     * If current char exists in map, reset the position to current char's next. (No duplication)
     * Compare current non-repeating substring length to max length and find longer one.
     *
     * @param s input string
     * @return max sub-string length
     */
    public int lengthOfLongestSubstring(String s) {

        /* Corner case */
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> m = new HashMap<>();
        int last = -1;      // index of last duplicated character
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                last = Math.max(last, m.get(s.charAt(i)));
            }

            m.put(s.charAt(i), i);
            max = Math.max(i - last, max);
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 test = new LengthOfLongestSubstring_3();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));       // 3
        System.out.println(test.lengthOfLongestSubstring("tmmzuxt"));       // 5
        System.out.println(test.lengthOfLongestSubstring("a"));
        System.out.println(test.lengthOfLongestSubstring("dvdf"));      // 3
    }
}


